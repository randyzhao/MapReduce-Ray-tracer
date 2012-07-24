/**  
 * Filename:    IRayProducer.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 24, 2012 11:58:30 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 24, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import java.io.IOException;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 24, 2012 11:58:30 PM
 */
public interface IRayProducer {
	void produceRay(String filePath, int height, int width) throws IOException;
}
