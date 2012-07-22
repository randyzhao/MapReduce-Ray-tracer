/**  
 * Filename:    DotLightSource.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 8:32:25 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.lightSource;

import photonMapping.Color;
import photonMapping.Vector;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 8:32:25 PM
 */
public class DotLightSource implements ILightSource {
	private Vector position;
	private Color color;

	public DotLightSource(Vector position, Color color) {
		this.position = position;
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.lightSource.ILightSource#getPosition()
	 */
	@Override
	public Vector getPosition() {
		return this.position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.lightSource.ILightSource#getColor()
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

}
