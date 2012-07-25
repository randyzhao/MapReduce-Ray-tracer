/**  
 * Filename:    RayHitInfo.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 25, 2012 12:19:29 AM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 25, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 25, 2012 12:19:29 AM
 */
public class RayHitInfo implements Writable {
	/**
	 * the position in the viewport
	 */
	private double xd, yd;
	private Color color;

	public double getXd() {
		return this.xd;
	}

	public void setXd(double xd) {
		this.xd = xd;
	}

	public double getYd() {
		return this.yd;
	}

	public void setYd(double yd) {
		this.yd = yd;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @param args
	 * @author Hongze Zhao	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RayHitInfo(String inputStr) {
		this.fromFormatString(inputStr);
	}

	public RayHitInfo(double xd, double yd, Color color) {
		this.xd = xd;
		this.yd = yd;
		this.color = color;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
	 */
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.io.Writable#write(java.io.DataOutput)
	 */
	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	public void fromFormatString(String input) {
		String[] ss = input.split(",");
		this.xd = Double.parseDouble(ss[0]);
		this.yd = Double.parseDouble(ss[1]);
		this.color = new Color(Double.parseDouble(ss[2]),
				Double.parseDouble(ss[3]), Double.parseDouble(ss[4]));

	}

	public String asFormatString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.xd).append(",").append(this.yd).append(",");
		sb.append(this.color.getRed()).append(",").append(this.color.getBlue())
		.append(",").append(this.color.getGreen());
		return sb.toString();
	}

}
