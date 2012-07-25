/**  
 * Filename:    Tester.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 25, 2012 9:57:43 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 25, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import photonMapping.Color;
import photonMapping.RayHitInfo;
import photonMapping.Vector;
import photonMapping.ranTracing.Camera;
import photonMapping.ranTracing.DistributedRayProducer;
import photonMapping.ranTracing.GeneralRayTracer;
import photonMapping.ranTracing.IRayTracer;
import photonMapping.ranTracing.JPEGGenerator;
import photonMapping.scene.Background;
import photonMapping.scene.Scene;
import photonMapping.shape.ObjShape;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 25, 2012 9:57:43 PM
 */
public class Tester {

	/**
	 * @param args
	 * @author Hongze Zhao
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		DistributedRayProducer rp = new DistributedRayProducer(2);
		rp.produceRay("ray.txt", 200, 200);
		Scene scene = new Scene();
		scene.addShape(new ObjShape("elephal.obj"));
		scene.setBackground(new Background(new Color(0.5, 0.4, 0.3), 0.5));
		scene.setCamera(new Camera(new Vector(-800, 0, 0), new Vector(5, 0, 0), new Vector(0, 0, 1)));
		IRayTracer rt = new GeneralRayTracer(scene, 2);
		BufferedReader br = new BufferedReader(new FileReader("ray.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("trace.txt"));
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != null) {
			count++;
			if (count % 5000 == 0) {
				System.out.println(count);
			}
			String[] ss = line.split(",");
			RayHitInfo hi = rt.rayTrace(Double.parseDouble(ss[0]),
					Double.parseDouble(ss[1]));
			bw.write(hi.asFormatString() + "\n");
		}
		br.close();
		bw.close();
		JPEGGenerator.generateFromFile("trace.txt", "result.jpg", 500, 500);
	}

}
