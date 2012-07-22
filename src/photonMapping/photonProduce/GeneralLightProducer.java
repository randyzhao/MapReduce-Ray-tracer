/**  
 * Filename:    GeneralProducer.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 1:43:33 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.photonProduce;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import photonMapping.Photon;
import photonMapping.Vector;
import photonMapping.scene.Scene;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 22, 2012 1:43:33 PM
 */
public class GeneralLightProducer {
	private Scene scene;
	private Random ran = new Random();

	public GeneralLightProducer(Scene scene) {
		this.scene = scene;
	}

	public void producePhotons(String filePath, int photonNumber)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for (int i = 0; i < photonNumber; i++){
			Photon photon = new Photon();
			photon.setColor(this.scene.getLightSource().getColor());
			photon.setDirection(this.randomDirection());
			photon.setSourcePosition(this.scene.getLightSource().getPosition());
			bw.write(photon.asFormatString() + "\n");
		}
		bw.close();
	}

	public Vector randomDirection() {
		double alpha = this.ran.nextDouble() * 2 * Math.PI;
		double beta = this.ran.nextDouble() * 2 * Math.PI;
		double y = Math.cos(alpha);
		double x = Math.sin(alpha);
		double z = Math.sin(beta);
		return new Vector(x, y, z);
	}

	public static void main(String[] args) throws IOException {
		GeneralLightProducer lp = new GeneralLightProducer(Scene.testScene());
		lp.producePhotons("testPhotons.txt", 10000);
		System.out.println("Ok");
	}
}
