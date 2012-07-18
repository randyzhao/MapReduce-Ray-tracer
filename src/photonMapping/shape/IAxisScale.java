/**  
 * Filename:    IAxisScale.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 19, 2012 1:44:20 AM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 19, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.shape;

/**
 * The class which can return x, y, z scale
 * 
 * @author Hongze Zhao Create At : Jul 19, 2012 1:44:20 AM
 */
public interface IAxisScale {
	double minX();

	double maxX();

	double minY();

	double maxY();

	double minZ();

	double maxZ();

}
