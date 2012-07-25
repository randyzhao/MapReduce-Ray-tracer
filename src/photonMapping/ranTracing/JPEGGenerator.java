/**  
 * Filename:    JPEGGenerator.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 25, 2012 8:38:29 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 25, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import org.aspectj.weaver.Position;

import photonMapping.Color;
import photonMapping.RayHitInfo;

import com.sun.image.codec.jpeg.ImageFormatException;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 25, 2012 8:38:29 PM
 */
public class JPEGGenerator {
	private static class PositionPair {
		int x, y;

		public int getX() {
			return this.x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return this.y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 16223;
			int result = 1;
			result = prime * result + this.x;
			result = prime * result + this.y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			PositionPair other = (PositionPair) obj;
			if (this.x != other.x) {
				return false;
			}
			if (this.y != other.y) {
				return false;
			}
			return true;
		}

		public PositionPair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void generateFromFile(String inputfilePath,
			String outputFilePath, int width, int height)
					throws IOException {
		HashMap<PositionPair, LinkedList<Color>> hm = new HashMap<PositionPair, LinkedList<Color>>();
		BufferedReader br = new BufferedReader(new FileReader(inputfilePath));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.equals("")) {
				continue;
			}
			RayHitInfo hi = new RayHitInfo(line);
			int x = (int) hi.getXd();
			int y = (int) hi.getYd();
			PositionPair pp = new PositionPair(x, y);
			if (!hm.containsKey(pp)) {
				hm.put(pp, new LinkedList<Color>());
			}
			hm.get(pp).add(hi.getColor());
		}
		JPEGGenerator.createJPEG(outputFilePath, width, height, hm);


	}

	private static void createJPEG(String filePath, int width, int height,
			HashMap<PositionPair, LinkedList<Color>> hm)
					throws ImageFormatException, IOException {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				List<Color> colors = hm.get(new Position(i, j));
				Color avCol = Color.averageColor(colors);
				bi.setRGB(i, j, avCol.toIntValue());
			}
		}
		bi.flush();
		JPEGGenerator.saveToFile(bi, new File(filePath));

	}

	private static void saveToFile(BufferedImage bi, File file)
			throws IOException {
		ImageWriter writer = null;
		Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
		if (iter.hasNext()) {
			writer = iter.next();
		}
		ImageOutputStream ios = ImageIO.createImageOutputStream(file);
		writer.setOutput(ios);
		ImageWriteParam param = new JPEGImageWriteParam(Locale.getDefault());
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.98f);
		writer.write(null, new IIOImage(bi, null, null), param);
	}
	/**
	 * @param args
	 * @author Hongze Zhao
	 * @throws IOException
	 * @throws ImageFormatException
	 */
	public static void main(String[] args) throws ImageFormatException,
	IOException {
		// TODO Auto-generated method stub
		JPEGGenerator.createJPEG("test.jpg", 100, 100,
				new HashMap<PositionPair, LinkedList<Color>>());
	}

}
