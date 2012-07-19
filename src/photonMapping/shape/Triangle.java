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
		 minx = Double.MAX_VALUE;
         maxx = -Double.MAX_VALUE;
         for (Vector vv : v){
        	 if (vv.getX() < minx){
        		 minx = vv.getX();
        	 }
        	 if (vv.getX() > maxx){
        		 maxx = vv.getX();
        	 }
         }
	}
	
	private void assignYScale(){
		miny = Double.MAX_VALUE;
		maxy = -Double.MAX_VALUE;
		for (Vector vv : v){
			if (vv.getY() < miny){
				miny = vv.getY();
			}
			if (vv.getY() > maxy){
				maxy = vv.getY();
			}
		}
	}
	
	private void assignZScale(){
		minz = Double.MAX_VALUE;
		maxz = -Double.MAX_VALUE; 
		for (Vector vv : v){
			if (vv.getZ() < minz){
				minz = vv.getZ();
			}
			if (vv.getZ() > maxz){
				maxz = vv.getZ();
			}
		}
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

	@Override
	public IntersectInformation intersect(IDirected directed) {
		// TODO Auto-generated method stub
		return null;
	}

}
