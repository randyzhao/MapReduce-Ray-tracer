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

import photonMapping.Color;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 2:52:12 PM
 */
public class GeneralMaterial implements IMaterial {

	protected double reflection;
	protected double refraction;
	protected double refractivity;
	protected Color color;

	public GeneralMaterial(double reflection, double refraction,
			double refractivity, Color color) {
		super();
		this.reflection = reflection;
		this.refraction = refraction;
		this.refractivity = refractivity;
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#getReflection()
	 */
	@Override
	public double getReflection() {
		return this.reflection;
	}

	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#getRefraction()
	 */
	@Override
	public double getRefraction() {
		return this.refraction;
	}

	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#getRefractivity()
	 */
	@Override
	public double getRefractivity() {
		return this.refractivity;
	}

	/* (non-Javadoc)
	 * @see photonMapping.materials.IMaterial#getColor()
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

}
