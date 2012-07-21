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

import photonMapping.Ray;
import photonMapping.shape.IShape;
import photonMapping.shape.IntersectInfo;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 3:24:54 PM
 */
public class ShapesKDTree extends KDTree<IShape> {
	protected ShapesKDTree leftChild;
	protected ShapesKDTree rightChild;

	public IntersectInfo intersect(Ray ray) {
		IntersectInfo ii = new IntersectInfo();
		ii.setHit(false);
		if (this.boundingVolumn.isIntersected(ray) == false){
			return ii;
		}
		if (this.leaf){
			IntersectInfo tempii = this.content.intersect(ray);
			if (tempii.isHit()) {
				ii = tempii;
			}
		} else {// not a leaf
			switch (this.seperateMethod){
			case XAxis:
				if (this.seperatePlain.intersect(ray).isHit() == false){
					if (ray.getPosition().getX() <= this.seperatePlain.getPosition().getX()){
						ii = this.leftChild.intersect(ray);
					}else{
						ii = this.rightChild.intersect(ray);
					}
				}else{//ray cross the plane
					if (ray.getPosition().getX() <= this.seperatePlain.getPosition().getX()){
						ii = this.leftChild.intersect(ray);
						if (ii.isHit() == false){
							ii = this.rightChild.intersect(ray);
						}
					}else{
						ii = this.rightChild.intersect(ray);
						if (ii.isHit() == false){
							ii = this.leftChild.intersect(ray);
						}
					}
				}
				break;

			case YAxis:
				if (this.seperatePlain.intersect(ray).isHit() == false){
					if (ray.getPosition().getY() <= this.seperatePlain.getPosition().getY()){
						ii = this.leftChild.intersect(ray);
					}else{
						ii = this.rightChild.intersect(ray);
					}
				}else{
					if (ray.getPosition().getY() <= this.seperatePlain.getPosition().getY()){
						ii = this.leftChild.intersect(ray);
						if (ii.isHit() == false){
							ii = this.rightChild.intersect(ray);
						}
					}else{
						ii = this.rightChild.intersect(ray);
						if (ii.isHit() == false){
							ii = this.leftChild.intersect(ray);
						}
					}
				}
				break;

			case ZAxis:
				if (this.seperatePlain.intersect(ray).isHit() == false)//ray didn't across the plane
				{
					if (ray.getPosition().getZ() <= this.seperatePlain.getPosition().getZ()) {
						ii = this.leftChild.intersect(ray);
					} else {
						ii = this.rightChild.intersect(ray);
					}
				}
				else//ray across the plane
				{
					if (ray.getPosition().getZ() <= this.seperatePlain.getPosition().getZ())
					{
						ii = this.leftChild.intersect(ray);
						if (ii.isHit() == false) {
							ii = this.rightChild.intersect(ray);
						}
					}
					else
					{
						ii = this.rightChild.intersect(ray);
						if (ii.isHit() == false) {
							ii = this.leftChild.intersect(ray);
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
}
