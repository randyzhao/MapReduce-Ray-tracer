/**  
 * Filename:    ILightSource.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 8:31:14 PM  
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
 * Create At : Jul 21, 2012 8:31:14 PM
 */
public interface ILightSource {
	Vector getPosition();

	Color getColor();

}
