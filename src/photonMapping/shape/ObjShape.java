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
import photonMapping.DataStructure.KDTree;
import photonMapping.DataStructure.ShapesKDTree;
import photonMapping.materials.SolidMetal;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 23, 2012 8:47:21 PM
 */
public class ObjShape extends GeneralShape {
	private ShapesKDTree tree;
	private List<Vector> vertexList = new ArrayList<Vector>();
	private List<Triangle> triangles = new ArrayList<Triangle>();

	public ObjShape(String filePath) throws NumberFormatException, IOException {
		this.material = new SolidMetal();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = br.readLine()) != null) {
			String[] ss = line.split(" ");
			if (ss[0].equals("v")) {
				this.vertexList.add(new Vector(Double.parseDouble(ss[1]),
						Double.parseDouble(ss[2]), Double.parseDouble(ss[3])));
			} else if (ss[0].equals("f")) {
				this.triangles.add(new Triangle(this.vertexList.get(Integer
						.parseInt(ss[1]) - 1), this.vertexList.get(Integer
								.parseInt(ss[2]) - 1), this.vertexList.get(Integer
										.parseInt(ss[3]) - 1), new SolidMetal()));
			}
		}
		this.tree = KDTree<Triangle>.
	}
	/* (non-Javadoc)
	 * @see photonMapping.shape.IShape#intersect(photonMapping.IDirected)
	 */
	@Override
	public IntersectInfo intersect(IDirected directed) {
		// TODO Auto-generated method stub
		return null;
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

}
