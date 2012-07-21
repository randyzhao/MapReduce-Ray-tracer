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
	IntersectInfo intersect(IDirected directed);
}
