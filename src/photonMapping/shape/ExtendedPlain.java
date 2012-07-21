/**  
 * Filename:    Plain.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 3:29:28 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.shape;

import java.util.List;

import photonMapping.IDirected;
import photonMapping.PhotonHitInfo;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

/**
 * An plain with no boundary
 * Assume the equation of a plain is P * N + d = 0 
 * @author Hongze Zhao Create At : Jul 21, 2012 3:29:28 PM
 */
public class ExtendedPlain extends GeneralShape {
	private Vector normal;
	private Vector position;
	private double d;
	private Vector right;
	private Vector up;
	private IMaterial material;
	public Vector getNormal() {
		return this.normal;
	}

	public void setNormal(Vector normal) {
		this.normal = normal;
	}

	private static final double INTERSECT_TORRENCE = 0;
	public ExtendedPlain(Vector position, Vector normal, IMaterial material){
		this.position = position;
		this.normal = normal;
		this.material = material;
		if (normal.getY() != 0 || normal.getZ() != 0){
			this.right = (new Vector(0, normal.getZ(), -normal.getY())).normilize();
		}else{
			this.right = new Vector(0, 1, 0);
		}
		this.up = (normal.cross(this.right)).normilize();
	}
	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#getPosition()
	 */
	@Override
	public Vector getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#getMaterial()
	 */
	@Override
	public IMaterial getMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#getPhotonHitInformations()
	 */
	@Override
	public List<PhotonHitInfo> getPhotonHitInformations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#intersect(photonMapping.IDirected)
	 */
	@Override
	public IntersectInfo intersect(IDirected directed) {
		IntersectInfo ii = new IntersectInfo();
		ii.setHit(false);
		double t = (this.position.minus(directed.getPosition())
				.multiple(this.normal))
				/ (directed.getDirection().multiple(this.normal));
		if (t <= Double.MIN_NORMAL){
			return ii;
		}
		ii.setHit(true);
		ii.setContent(this);
		ii.setPosition(directed.getPosition().plus(
				directed.getDirection().multiple(t)));
		return ii;
	}

}
