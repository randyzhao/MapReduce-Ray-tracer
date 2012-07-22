/**  
 * Filename:    Background.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 10:41:37 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.scene;

import photonMapping.Color;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 22, 2012 10:41:37 PM
 */
public class Background {
	private Color color;
	private double ambiance;

	public Background(Color color, double ambiance) {
		this.color = color;
		this.ambiance = ambiance;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getAmbiance() {
		return this.ambiance;
	}

	public void setAmbiance(double ambiance) {
		this.ambiance = ambiance;
	}

}
