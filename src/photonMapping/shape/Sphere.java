/**  
 * Filename:    Sphere.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 20, 2012 12:55:54 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 20, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 20, 2012 12:55:54 PM
 */
public class Sphere extends GeneralShape {

	private double radius;
	private Vector center;
	private IMaterial material;

	public Sphere(double radius, Vector center, IMaterial material) {
		this.radius = radius;
		this.center = center;
		this.material = material;
	}
	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#intersect(photonMapping.IDirected)
	 */
	@Override
	public IntersectInfo intersect(IDirected directed) {
		IntersectInfo ii = new IntersectInfo();
		double loc2 = this.center.distanceSquare(directed.getPosition());
		double tca = (this.center.minus(directed.getPosition())).dot(
				directed.getDirection().normilize());
		double thc2 = this.radius * this.radius - loc2 + tca * tca;
		if (tca >= 0 && thc2 > 0) {
			double sqrtNum = Math.sqrt(thc2);
			double t = tca - sqrtNum;
			if (t < 0) {
				t = tca + sqrtNum;
			}
			Vector intersect = directed.getPosition().plus(
					directed.getDirection().normilize().multiple(t));
			ii.setHit(true);
			ii.setPosition(intersect);
			ii.setNormal((ii.getPosition().minus(this.center)).normilize());

		} else {
			ii.setHit(false);
		}
		return ii;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		return this.center.getX() - this.radius;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		return this.center.getX() + this.radius;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		return this.center.getY() - this.radius;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		return this.center.getY() + this.radius;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		return this.center.getZ() - this.radius;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		return this.center.getZ() + this.radius;
	}

}
