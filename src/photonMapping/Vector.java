package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Vector implements Writable {
	private double x;
	private double y;
	private double z;

	public Vector() {
		this.x = this.y = this.z = 0;
	}

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	private static Vector NULL = null, INFINIT = null;

	public static Vector getNull() {
		if (Vector.NULL == null) {
			Vector.NULL = new Vector(0, 0, 0);
		}
		return Vector.NULL;
	}

	public static Vector getInfinit() {
		if (Vector.INFINIT == null){
			Vector.INFINIT = new Vector(Double.MAX_VALUE, Double.MAX_VALUE,
					Double.MAX_VALUE);
		}
		return Vector.INFINIT;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	/**
	 * a vector's length(magnitude)
	 * 
	 * @return
	 * @author Hongze Zhao
	 */
	public double magnitude() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	/**
	 * get the normalized vector this magnitude of this vector is one
	 * 
	 * @return
	 * @author Hongze Zhao
	 */
	public Vector normilize() {
		double mag = this.magnitude();
		return new Vector(this.x / mag, this.y / mag, this.z / mag);
	}

	public Vector plus(Vector a) {
		return new Vector(this.x + a.x, this.y + a.y, this.z + a.z);
	}

	public Vector minus(Vector a) {
		return new Vector(this.x - a.x, this.y - a.y, this.z - a.z);
	}

	public Vector multiple(Vector a) {
		return new Vector(this.x * a.x, this.y * a.y, this.z * a.z);
	}

	public Vector multiple(double f) {
		return new Vector(this.x * f, this.y * f, this.z * f);
	}

	public Vector divide(double f) {
		return new Vector(this.x / f, this.y / f, this.z / f);
	}

	/**
	 * the square of the distance of two vector
	 * 
	 * @param a
	 * @return
	 * @author Hongze Zhao
	 */
	public double distanceSquare(Vector a) {
		return (this.x - a.x) * (this.x - a.x) + (this.y - a.y)
				* (this.y - a.y) + (this.z - a.z) * (this.z - a.z);
	}

	public double distance(Vector a) {

	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}
}
