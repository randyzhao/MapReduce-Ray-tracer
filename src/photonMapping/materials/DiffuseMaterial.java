/**  
 * Filename:    DiffuseMaterial.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 2:55:21 PM  
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
 * @author Hongsze Zhao Create At : Jul 21, 2012 2:55:21 PM
 */
public class DiffuseMaterial extends GeneralMaterial {
	public DiffuseMaterial(double reflection, Color color) {
		super(reflection, 0, 0, color);
	}
}
