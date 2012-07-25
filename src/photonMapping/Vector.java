
package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

import photonMapping.shape.IAxisScale;

public class Vector implements Writable, IAxisScale {

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

	public double multiple(Vector a) {
		return this.x + a.x + this.y * a.y + this.z * a.z;
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
		return Math.sqrt(this.distanceSquare(a));
	}
	public void clear() {
		this.x = this.y = this.z = 0;
	}

	public Vector reverse() {
		return new Vector(-this.x, -this.y, -this.z);
	}

	public double dot(Vector a) {
		return this.x * a.x + this.y * a.y + this.z * a.z;
	}

	public Vector cross(Vector a) {
		return new Vector(this.y * a.z - this.z * a.y, this.z * a.x - this.x
				* a.z, this.x * a.y - this.y * a.x);
	}
	public void fromFormatString(String input) {
		this.clear();
		int findex = input.indexOf(',');
		this.x = Double.parseDouble(input.substring(1, findex));
		int sindex = input.indexOf(',', findex + 1);
		this.y = Double.parseDouble(input.substring(findex + 1, sindex));
		this.z = Double.parseDouble(input.substring(sindex + 1, input.length() - 1));
	}

	public String asFormatString() {
		StringBuilder stringToBuild = new StringBuilder();
		stringToBuild.append('(');
		stringToBuild.append(this.x).append(',').append(this.y).append(',').append(this.z);
		stringToBuild.append(')');
		return stringToBuild.toString();
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		int length = WritableUtils.readVInt(input);
		byte[] bytes = new byte[length];
		input.readFully(bytes, 0, length);
		this.fromFormatString(new String(bytes));
	}

	@Override
	public void write(DataOutput output) throws IOException {
		String content = this.asFormatString();
		WritableUtils.writeVInt(output, content.length());
		output.writeBytes(content);
	}

	@Override
	public String toString() {
		return this.asFormatString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		return this.x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		return this.x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		return this.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		return this.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		return this.z;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		return this.z;
	}

	@Override
	public int hashCode() {
		Double dx = this.x;
		Double dy = this.y;
		Double dz = this.z;
		return dx.hashCode() * 43669 + dy.hashCode() * 20663 + dz.hashCode();
	}
}
