/**  
 * Filename:    Triangle.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 19, 2012 1:42:31 AM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 19, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.shape;

import photonMapping.IntersectInfo;
import photonMapping.Ray;
import photonMapping.Vector;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 19, 2012 1:42:31 AM
 */
public class Triangle extends GeneralShape implements IAxisScale {

	/**
	 * x, y, z
	 */
	protected Vector[] v = new Vector[3];
	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#intersect(photonMapping.Ray)
	 */
	@Override
	public IntersectInfo intersect(Ray r) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
