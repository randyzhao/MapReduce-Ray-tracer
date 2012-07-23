/**  
 * Filename:    SolidMetal.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 23, 2012 9:34:14 PM  
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
 * Create At : Jul 23, 2012 9:34:14 PM
 */
public class SolidMetal extends SolidMaterial {
	public SolidMetal() {
		super(new Color(0.718, 0.5234, 0.0430), 0.8, 0, 0.8, 0.5);
	}
}
