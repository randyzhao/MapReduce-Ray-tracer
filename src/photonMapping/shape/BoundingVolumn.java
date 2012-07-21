/**
 * 
 */
package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;

/**
 * @author v-honzha
 * 
 */
public class BoundingVolumn {

	private Vector minV, maxV;

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	public double minX() {
		return minV.getX();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	public double maxX() {
		return maxV.getX();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	public double minY() {
		return minV.getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	public double maxY() {
		return maxV.getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	public double minZ() {
		return minV.getZ();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	public double maxZ() {
		return maxV.getZ();
	}

	/**
	 * 
	 * @param min
	 *            the min vector
	 * @param max
	 *            the max vector
	 */
	public BoundingVolumn(Vector min, Vector max) {
		this.minV = min;
		this.maxV = max;
	}

	public boolean isIntersected(IDirected directed) {
		double ox = directed.getPosition().getX();
		double oy = directed.getPosition().getY();
		double oz = directed.getPosition().getZ();

		double dx = directed.getDirection().getX();
		double dy = directed.getDirection().getY();
		double dz = directed.getDirection().getZ();

		double x0 = this.minX();
		double y0 = this.minY();
		double z0 = this.minZ();

		double x1 = this.maxX();
		double y1 = this.maxY();
		double z1 = this.maxZ();

		double tx_min, ty_min, tz_min = 0;
		double tx_max, ty_max, tz_max = 0;

		// to prevent an axis is equal
		if (x1 == x0) {
			x1++;
		}
		if (y1 == y0) {
			y1++;
		}
		if (z1 == z0) {
			z1++;
		}
		if (x0 <= ox && ox <= x1 && y0 <= oy && oy <= y1 && z0 <= oz && oz <= z1){
			//the sourcePositon is in the box
			return true;
		}
		
		double a= 1.0 / dx;
		if (a >= 0){
			tx_min = (x0 - ox) * a;
			tx_max = (x1 - ox) * a;
		}else{
			tx_min = (x1 - ox) * a;
			tx_max = (x0 - ox) * a;
		}
		
		double b = 1.0 / dy;
		if (b >= 0){
			ty_min = (y0 - oy) * b;
			ty_max = (y1 - oy) * b;
		}else{
			ty_min = (y1 - oy) * b;
			ty_max = (y0 - oy) * b;
		}
		
		double c = 1.0 / dz;
		if (c >= 0){
			tz_min = (z0 - oz) * c;
			tz_max = (z1 - oz) * c;
		}
		
		double t0, t1;
		//find largest entering t value
		t0 = Math.max(tx_min, ty_min);
		if (tz_min > t0){
			t0 = tz_min;
		}
		//find the smallest exiting t value
		t1 = Math.min(tx_max, ty_max);
		t1 = Math.min(t1,  tz_max);
		return t0 < t1 && t1 > Double.MIN_VALUE;
		
	}

}
