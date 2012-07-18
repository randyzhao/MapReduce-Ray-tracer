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

	public static Vector getNullVector(){
		if (Vector.NULL == null) {
			Vector.NULL = new Vector(0, 0, 0);
		}
		return Vector.NULL;
	}

	public static Vector getInfinitVector(){
		if (Vector.INFINIT == null){
			Vector.INFINIT = new Vector(Double.max)
		}
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
