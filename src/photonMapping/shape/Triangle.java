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
	private Vector normal;
	/**
	 * 3 vertices of the triangle
	 */
	private Vector[] v = new Vector[3];
	public Triangle(Vector a, Vector b, Vector c, IMaterial material){
		this.v[0] = a;
		this.v[1] = b;
		this.v[2] = c;
		this.normal = b.minus(a).cross(c.minus(a)).normilize();
		this.assignXSacle();
		this.assignYScale();
		this.assignZScale();
		this.material = material;
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
		IntersectInfo output = new IntersectInfo();
		output.setHit(false);
		Double a = this.v[0].getX() - this.v[1].getX(), b = this.v[0].getX()
				- this.v[2].getX(), c = directed.getDirection().getX(), d = this.v[0]
						.getX() - directed.getPosition().getX();
		Double e = this.v[0].getY() - this.v[1].getY(), f = this.v[0].getY()
				- this.v[2].getY(), g = directed.getDirection().getY(), h = this.v[0]
						.getY() - directed.getPosition().getY();
		Double i = this.v[0].getZ() - this.v[1].getZ(), j = this.v[0].getZ()
				- this.v[2].getZ(), k = directed.getDirection().getZ(), l = this.v[0]
						.getZ() - directed.getPosition().getZ();
		Double m = f * k - g * j, n = h * k - g * l, p = f * l - h * j;
		Double q = g * i - e * k, s = e * j - f * i;

		Double inv_denom = 1.0 / (a * m + b * q + c * s);
		Double el = d * m - b * n - c * p;
		Double beta = el * inv_denom;

		if (beta < 0.0) {
			return output;
		}
		Double r = e * l - h * i;
		Double e2 = a * n + d * q + c * r;
		Double gamma = e2 * inv_denom;

		if (gamma < 0.0 || beta + gamma > 1.0) {
			return output;
		}

		Double e3 = a * p - b * r + d * s;
		Double t = e3 * inv_denom;
		if (t < Double.MIN_NORMAL) {
			return output;
		}

		// is intersect
		output.setHit(true);
		output.setNormal(this.normal);
		output.setColor(this.material.getColor(0, 0));
		output.setMaterial(this.material);
		output.setContent(this);
		output.setPosition(directed.getDirection().plus(
				directed.getDirection().multiple(t)));
		output.setDistance(directed.getDirection().magnitude() * t);
		return output;
	}

}
