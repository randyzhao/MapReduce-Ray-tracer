/**  
 * Filename:    ObjShape.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 23, 2012 8:47:21 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 23, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.shape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.DataStructure.ShapesKDTree;
import photonMapping.materials.SolidMetal;

/**
 * 
 * @author Hongze Zhao Create At : Jul 23, 2012 8:47:21 PM
 */
public class ObjShape extends GeneralShape {
	private ShapesKDTree tree;
	private List<Vector> vertexList = new ArrayList<Vector>();
	private List<Triangle> triangles = new ArrayList<Triangle>();
	private double minX = Double.MAX_VALUE;
	private double maxX = -Double.MAX_VALUE;
	private double minY = Double.MAX_VALUE;
	private double maxY = -Double.MAX_VALUE;
	private double minZ = Double.MAX_VALUE;
	private double maxZ = -Double.MAX_VALUE;

	public ObjShape(String filePath) throws NumberFormatException, IOException {
		this.material = new SolidMetal();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = br.readLine()) != null) {
			try {
				String[] ss = line.split(" ");
				if (ss[1].equals("")) {
					ss[1] = ss[2];
					ss[2] = ss[3];
					ss[3] = ss[4];
				}
				if (ss[0].equals("v")) {
					this.vertexList.add(new Vector(Double.parseDouble(ss[1]),
							Double.parseDouble(ss[2]), Double.parseDouble(ss[3])));
				} else if (ss[0].equals("f")) {
					ss[1] = ss[1].split("//")[0];
					ss[2] = ss[1].split("//")[0];
					ss[3] = ss[1].split("//")[0];
					this.triangles.add(new Triangle(this.vertexList.get(Integer
							.parseInt(ss[1]) - 1), this.vertexList.get(Integer
									.parseInt(ss[2]) - 1), this.vertexList.get(Integer
											.parseInt(ss[3]) - 1), new SolidMetal()));
					this.updateScale(this.triangles.get(this.triangles.size() - 1));
				}
			} catch (NumberFormatException ex) {
				System.err.println(line);
			} catch (Exception ex) {
				System.err.println(line);
			}
		}
		this.tree = ShapesKDTree.buildKDTree(this.triangles);
		System.out.println("x : " + this.minX + " to " + this.maxX);
		System.out.println("y : " + this.minY + " to " + this.maxY);
		System.out.println("z : " + this.minZ + " to " + this.maxZ);
	}

	private void updateScale(IAxisScale a) {
		this.minX = Math.min(this.minX, a.minX());
		this.maxX = Math.max(this.maxX, a.maxX());
		this.minY = Math.min(this.minY, a.minY());
		this.maxY = Math.max(this.maxY, a.maxY());
		this.minZ = Math.min(this.minZ, a.minZ());
		this.maxZ = Math.max(this.maxZ, a.maxZ());
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IShape#intersect(photonMapping.IDirected)
	 */
	@Override
	public IntersectInfo intersect(IDirected directed) {
		return this.tree.intersect(directed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minX()
	 */
	@Override
	public double minX() {
		return this.minX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxX()
	 */
	@Override
	public double maxX() {
		return this.maxX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minY()
	 */
	@Override
	public double minY() {
		return this.minY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxY()
	 */
	@Override
	public double maxY() {
		return this.maxY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#minZ()
	 */
	@Override
	public double minZ() {
		return this.minZ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.shape.IAxisScale#maxZ()
	 */
	@Override
	public double maxZ() {
		return this.maxZ;
	}

	public static void main(String[] args) throws NumberFormatException,
	IOException {
		new ObjShape("elephal.obj");
		System.out.println("ok");
	}

}
