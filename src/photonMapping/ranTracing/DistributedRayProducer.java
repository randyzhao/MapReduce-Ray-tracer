/**  
 * Filename:    DistributedRayProducer.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 24, 2012 11:59:09 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 24, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 24, 2012 11:59:09 PM
 */
public class DistributedRayProducer implements IRayProducer {
	private int jitterNumber;

	public DistributedRayProducer(int jitterNumber) {
		this.jitterNumber = jitterNumber;

	}
	/**
	 * @param args
	 * @author Hongze Zhao	
	 */
	public static void main(String[] args) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.ranTracing.IRayProducer#produceRay(java.lang.String,
	 * int, int)
	 */
	@Override
	public void produceRay(String filePath, int height, int width)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		Random ran = new Random();
		for (int y = 0; y < height + 2; y++) {
			for (int x = 0; x < width + 2; x++) {
				for (int p = 0; p < this.jitterNumber; p++){
					for (int q = 0; q < this.jitterNumber; q++){
						double yd = (y + (p + ran.nextDouble()) / this.jitterNumber) * 1.0f / height * 2 - 1;
						double xd = (x + (q + ran.nextDouble()) / this.jitterNumber) * 1.0f / width * 2 - 1;
						StringBuilder sb = new StringBuilder();
						sb.append(xd).append(",").append(yd).append('\n');
						bw.write(sb.toString());
					}
				}
			}
		}
		bw.close();
	}


}
