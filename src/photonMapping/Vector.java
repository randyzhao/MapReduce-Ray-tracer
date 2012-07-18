package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Vector implements Writable {
	private final double x;
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

	private static Vector NULL, INFINIT;

	public static Vector getNullVector(){
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
