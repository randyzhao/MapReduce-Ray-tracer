/**  
 * Filename:    SolidMaterial.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 23, 2012 9:30:07 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 23, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.materials;

import photonMapping.Color;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 23, 2012 9:30:07 PM
 */
public class SolidMaterial extends BaseMaterial {

	private Color color;

	public SolidMaterial(Color col, double gloss, double trans, double refra, double refle){
		this.color = col;
		this.gloss = gloss;
		this.transparency = trans;
		this.reflection = refle;
		this.refraction = refra;
	}

	@Override
	public boolean has2DTexture() {
		return false;
	}

	@Override
	public Color getColor(double u, double v) {
		return this.color;
	}


}
