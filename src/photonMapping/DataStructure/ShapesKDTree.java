/**  
 * Filename:    ShapesKDTree.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 3:24:54 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.DataStructure;

import java.util.LinkedList;
import java.util.List;

import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.shape.BoundingVolumn;
import photonMapping.shape.ExtendedPlain;
import photonMapping.shape.IAxisScale;
import photonMapping.shape.IShape;
import photonMapping.shape.IntersectInfo;
import photonMapping.shape.Triangle;

/**
 * 
 * @author Hongze Zhao Create At : Jul 21, 2012 3:24:54 PM
 */
public class ShapesKDTree extends KDTree<IShape> {
	protected ShapesKDTree leftChild;
	protected ShapesKDTree rightChild;
	protected List<Triangle> contents;

	public void buildBoundingVolumn() {
		if (this.leaf) {
			double maxX = -Double.MAX_VALUE;
			double minX = Double.MAX_VALUE;
			double maxY = -Double.MAX_VALUE;
			double minY = Double.MAX_VALUE;
			double maxZ = -Double.MAX_VALUE;
			double minZ = Double.MAX_VALUE;
			for (Triangle t : this.contents) {
				maxX = Math.max(maxX, t.maxX());
				minX = Math.min(minX, t.minX());
				maxY = Math.max(maxY, t.maxY());
				minY = Math.min(minY, t.minY());
				maxZ = Math.max(maxZ, t.maxZ());
				minZ = Math.min(minZ, t.minZ());
			}
			this.boundingVolumn = new BoundingVolumn(new Vector(minX, minY, minZ),
					new Vector(maxX, maxY, maxZ));
		} else {
			this.leftChild.buildBoundingVolumn();
			this.rightChild.buildBoundingVolumn();
			double minX = Math.min(this.leftChild.getBoundingVolumn().minX(),
					this.rightChild.getBoundingVolumn().minX());
			double minY = Math.min(this.leftChild.getBoundingVolumn().minY(),
					this.rightChild.getBoundingVolumn().minY());
			double minZ = Math.min(this.leftChild.getBoundingVolumn().minZ(),
					this.rightChild.getBoundingVolumn().minZ());
			double maxX = Math.max(this.leftChild.getBoundingVolumn().maxX(),
					this.rightChild.getBoundingVolumn().maxX());
			double maxY = Math.max(this.leftChild.getBoundingVolumn().maxY(),
					this.rightChild.getBoundingVolumn().maxY());
			double maxZ = Math.max(this.leftChild.getBoundingVolumn().maxZ(),
					this.rightChild.getBoundingVolumn().maxZ());
			this.boundingVolumn = new BoundingVolumn(new Vector(minX, minY,
					minZ), new Vector(maxX, maxY, maxZ));
		}
	}

	public IntersectInfo intersect(IDirected directed) {
		IntersectInfo ii = new IntersectInfo();
		ii.setHit(false);
		if (this.boundingVolumn == null) {
			this.buildBoundingVolumn();
		}
		if (this.boundingVolumn.isIntersected(directed) == false) {
			return ii;
		}
		if (this.leaf) {
			double nearestDist = Double.MAX_VALUE;
			IntersectInfo nearestII = null;
			for (IShape shape : this.contents) {
				IntersectInfo tempii = shape.intersect(directed);
				if (tempii.isHit() && tempii.getDistance() < nearestDist) {
					nearestDist = tempii.getDistance();
					nearestII = tempii;
				}
			}
			if (nearestII != null) {
				ii = nearestII;
			}
		} else {// not a leaf
			switch (this.seperateMethod) {
			case XAxis:
				if (this.seperatePlain.intersect(directed).isHit() == false) {
					if (directed.getPosition().getX() <= this.seperatePlain
							.getPosition().getX()) {
						ii = this.leftChild.intersect(directed);
					} else {
						ii = this.rightChild.intersect(directed);
					}
				} else {// ray cross the plane
					if (directed.getPosition().getX() <= this.seperatePlain
							.getPosition().getX()) {
						ii = this.leftChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.rightChild.intersect(directed);
						}
					} else {
						ii = this.rightChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.leftChild.intersect(directed);
						}
					}
				}
				break;

			case YAxis:
				if (this.seperatePlain.intersect(directed).isHit() == false) {
					if (directed.getPosition().getY() <= this.seperatePlain
							.getPosition().getY()) {
						ii = this.leftChild.intersect(directed);
					} else {
						ii = this.rightChild.intersect(directed);
					}
				} else {
					if (directed.getPosition().getY() <= this.seperatePlain
							.getPosition().getY()) {
						ii = this.leftChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.rightChild.intersect(directed);
						}
					} else {
						ii = this.rightChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.leftChild.intersect(directed);
						}
					}
				}
				break;

			case ZAxis:
				if (this.seperatePlain.intersect(directed).isHit() == false) {
					// ray didn't across the plane
					if (directed.getPosition().getZ() <= this.seperatePlain
							.getPosition().getZ()) {
						ii = this.leftChild.intersect(directed);
					} else {
						ii = this.rightChild.intersect(directed);
					}
				} else {// ray across the plane

					if (directed.getPosition().getZ() <= this.seperatePlain
							.getPosition().getZ()) {
						ii = this.leftChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.rightChild.intersect(directed);
						}
					} else {
						ii = this.rightChild.intersect(directed);
						if (ii.isHit() == false) {
							ii = this.leftChild.intersect(directed);
						}
					}
				}
				break;

			default:
				break;
			}
		}
		return ii;
	}

	public static ShapesKDTree buildKDTree(List<Triangle> contents) {
		double maxX = -Double.MAX_VALUE;
		double minX = Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxZ = -Double.MAX_VALUE;
		double minZ = Double.MAX_VALUE;
		for (IAxisScale t : contents) {
			maxX = Math.max(maxX, t.maxX());
			minX = Math.min(minX, t.minX());
			maxY = Math.max(maxY, t.maxY());
			minY = Math.min(minY, t.minY());
			maxZ = Math.max(maxZ, t.maxZ());
			minZ = Math.min(minZ, t.minZ());
		}
		double xscale = maxX - minX;
		double yscale = maxY - minY;
		double zscale = maxZ - minZ;
		KDTreeSeperateMethodEnum method = KDTreeSeperateMethodEnum.XAxis;
		if (yscale >= xscale && yscale >= zscale) {
			method = KDTreeSeperateMethodEnum.YAxis;
		}
		if (zscale >= xscale && zscale >= yscale) {
			method = KDTreeSeperateMethodEnum.ZAxis;
		}
		double seperateValue;
		List<Triangle> leftChildContents = new LinkedList<Triangle>();
		List<Triangle> rightChildContents = new LinkedList<Triangle>();
		ExtendedPlain seperatePlain = null;
		switch (method) {
		case XAxis:
			seperateValue = (maxX - minX) / 2;
			for (Triangle t : contents) {
				if (t.minX() < seperateValue) {
					leftChildContents.add(t);
				}
				if (t.maxX() > seperateValue) {
					rightChildContents.add(t);
				}
			}
			seperatePlain = new ExtendedPlain(new Vector(seperateValue, 0, 0),
					new Vector(1, 0, 0), null);
			break;
		case YAxis:
			seperateValue = (maxY - minY) / 2;
			for (Triangle t : contents) {
				if (t.minY() < seperateValue) {
					leftChildContents.add(t);
				}
				if (t.maxY() > seperateValue) {
					rightChildContents.add(t);
				}
			}
			seperatePlain = new ExtendedPlain(new Vector(0, seperateValue, 0),
					new Vector(0, 1, 0), null);
			break;
		case ZAxis:
			seperateValue = (maxZ - minZ) / 2;
			for (Triangle t : contents) {
				if (t.minZ() < seperateValue) {
					leftChildContents.add(t);
				}
				if (t.maxZ() > seperateValue) {
					rightChildContents.add(t);
				}
			}
			seperatePlain = new ExtendedPlain(new Vector(0, 0, seperateValue),
					new Vector(0, 0, 1), null);
			break;

		default:
			break;
		}

		ShapesKDTree tree = new ShapesKDTree();
		tree.seperateMethod = method;
		tree.seperatePlain = seperatePlain;
		if (leftChildContents.size() == 0 || rightChildContents.size() == 0) {
			tree.contents = leftChildContents;
			if (tree.contents.size() == 0) {
				tree.contents = rightChildContents;
			}
			tree.setLeaf(true);
			return tree;
		}
		tree.setLeaf(false);
		tree.leftChild = ShapesKDTree.buildKDTree(leftChildContents);
		tree.rightChild = ShapesKDTree.buildKDTree(rightChildContents);
		return tree;
	}
}
