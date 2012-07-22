/**  
 * Filename:    IRayTracer.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 10:30:23 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import photonMapping.Color;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 22, 2012 10:30:23 PM
 */
public interface IRayTracer {
	Color rayTrace(double xd, double yd);
}
