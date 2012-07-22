/**
 * 
 */

package photonMapping.photonCast;

import java.util.List;

import photonMapping.Photon;
import photonMapping.PhotonHitInfo;

/**
 * the interface of class which can cast photon to the scene
 * 
 * @author v-honzha
 */
public interface IPhotonCaster {
	List<PhotonHitInfo> castPhoton(Photon photon);
}
