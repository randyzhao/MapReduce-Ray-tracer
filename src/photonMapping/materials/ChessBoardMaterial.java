/**  
 * Filename:    ChessBoardMaterial.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 11:30:04 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.materials;

import photonMapping.Color;

/**
 * 2D chess board material
 * 
 * @author Hongze Zhao Create At : Jul 22, 2012 11:30:04 PM
 */
public class ChessBoardMaterial extends BaseMaterial {

	private Color mainColor;
	private Color subColor;
	private double cellWidth;

	public ChessBoardMaterial(Color mainColor, Color subColor,
			double cellWidth, double gloss, double trans, double ref) {
		this.mainColor = mainColor;
		this.subColor = subColor;
		this.cellWidth = cellWidth;
		this.gloss = gloss;
		this.transparency = trans;
		this.reflection = ref;
	}
	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#has2DTexture()
	 */
	@Override
	public boolean has2DTexture() {
		return true;
	}

	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#getColor(double, double)
	 */
	@Override
	public Color getColor(double u, double v) {
		double temp = this.wrapUp(u / this.cellWidth)
				* this.wrapUp(v / this.cellWidth);
		if (temp < 0.0) {
			return this.mainColor;
		} else {
			return this.subColor;
		}
	}

}
