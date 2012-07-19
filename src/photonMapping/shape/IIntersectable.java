/**
 * 
 */
package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Ray;

/**
 * @author v-honzha
 *
 */
public interface IIntersectable extends IAxisScale {
	IntersectInformation intersect(IDirected directed);
}
