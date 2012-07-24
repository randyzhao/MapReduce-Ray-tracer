/**  
 * Filename:    KDTree.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 3:04:50 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.DataStructure;

import java.util.List;

import photonMapping.Vector;
import photonMapping.shape.BoundingVolumn;
import photonMapping.shape.ExtendedPlain;
import photonMapping.shape.IAxisScale;

/**
 * 
 * @author Hongze Zhao Create At : Jul 21, 2012 3:04:50 PM
 */
public class KDTree<T extends IAxisScale> {

	public enum KDTreeSeperateMethodEnum {
		XAxis, YAxis, ZAxis
	}

	protected boolean leaf;
	protected KDTree<T> leftChild;
	protected KDTree<T> rightChild;
	protected BoundingVolumn boundingVolumn;
	protected ExtendedPlain seperatePlain;
	protected KDTreeSeperateMethodEnum seperateMethod;
	protected List<T> contents;

	public boolean isLeaf() {
		return this.leaf;
	}

	public KDTree<T> getLeftChild() {
		return this.leftChild;
	}

	public KDTree<T> getRightChild() {
		return this.rightChild;
	}

	public BoundingVolumn getBoundingVolumn() {
		if (this.boundingVolumn == null) {
			this.buildBoundingVolumn();
		}
		return this.boundingVolumn;
	}

	public KDTreeSeperateMethodEnum getSeperateMethod() {
		return this.seperateMethod;
	}

	public List<T> getContents() {
		return this.contents;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public void setLeftChild(KDTree<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(KDTree<T> rightChild) {
		this.rightChild = rightChild;
	}

	public void buildBoundingVolumn() {
		double maxX = -Double.MAX_VALUE;
		double minX = Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxZ = -Double.MAX_VALUE;
		double minZ = Double.MAX_VALUE;
		for (T t : this.contents) {
			maxX = Math.max(maxX, t.maxX());
			minX = Math.min(minX, t.minX());
			maxY = Math.max(maxY, t.maxY());
			minY = Math.min(minY, t.minY());
			maxZ = Math.max(maxZ, t.maxZ());
			minZ = Math.min(minZ, t.minZ());
		}
		this.boundingVolumn = new BoundingVolumn(new Vector(minX, minY, minZ),
				new Vector(maxX, maxY, maxZ));
	}



}
