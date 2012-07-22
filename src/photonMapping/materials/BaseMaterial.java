/**  
 * Filename:    GeneralMaterial.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 2:52:12 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.materials;


/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 2:52:12 PM
 */
public abstract class BaseMaterial implements IMaterial {
	protected double gloss;
	protected double transparency;
	protected double reflection;
	protected double refraction;

	public BaseMaterial() {
	}

	@Override
	public double getGloss() {
		return this.gloss;
	}

	public void setGloss(double gloss) {
		this.gloss = gloss;
	}

	@Override
	public double getTransparency() {
		return this.transparency;
	}

	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	@Override
	public double getReflection() {
		return this.reflection;
	}

	public void setReflection(double reflection) {
		this.reflection = reflection;
	}

	@Override
	public double getRefraction() {
		return this.refraction;
	}

	public void setRefraction(double refraction) {
		this.refraction = refraction;
	}

	/**
	 * wraps any value up in the inteval [-scale,scale] in a rotational manner
	 * e.g. 1.7 -> -0.3
	 * 
	 * @param t
	 * @return
	 * @author Hongze Zhao
	 */
	protected double wrapUp(double t) {
		t = t % 2.0d;
		if (t < -1) {
			t += 2.0d;
		}
		if (t >= 1) {
			t -= 2.0d;
		}
		return t;
	}


}
