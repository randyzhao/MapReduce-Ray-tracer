/**
 * 
 */
package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

/**
 * @author v-honzha
 *
 */
public class Triangle extends GeneralShape implements IAxisScale {
	/**
	 * 3 vertices of the triangle
	 */
	private Vector[] v = new Vector[3];
	public Triangle(Vector a, Vector b, Vector c, IMaterial material){
		this.v[0] = a;
		this.v[1] = b;
		this.v[2] = c;
		this.assignXSacle();
		this.assignYScale();
		this.assignZScale();
	}
	private double minx, maxx, miny, maxy, minz, maxz;
	/**
	 * calculate minx and maxx
	 */
	private void assignXSacle(){
		this.minx = Double.MAX_VALUE;
		this.maxx = -Double.MAX_VALUE;
		for (Vector vv : this.v){
			if (vv.getX() < this.minx){
				this.minx = vv.getX();
			}
			if (vv.getX() > this.maxx){
				this.maxx = vv.getX();
			}
		}
	}

	private void assignYScale(){
		this.miny = Double.MAX_VALUE;
		this.maxy = -Double.MAX_VALUE;
		for (Vector vv : this.v){
			if (vv.getY() < this.miny){
				this.miny = vv.getY();
			}
			if (vv.getY() > this.maxy){
				this.maxy = vv.getY();
			}
		}
	}

	private void assignZScale(){
		this.minz = Double.MAX_VALUE;
		this.maxz = -Double.MAX_VALUE; 
		for (Vector vv : this.v){
			if (vv.getZ() < this.minz){
				this.minz = vv.getZ();
			}
			if (vv.getZ() > this.maxz){
				this.maxz = vv.getZ();
			}
		}
	}
	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		return this.minx;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		return this.maxx;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		return this.miny;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		return this.maxy;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		return this.minz;
	}

	/* (non-Javadoc)
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		return this.maxz;
	}

	@Override
	public IntersectInfo intersect(IDirected directed) {
		// TODO Auto-generated method stub
		return null;
	}

}
