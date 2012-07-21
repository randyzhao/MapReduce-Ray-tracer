/**
 * 
 */

package photonMapping;

import java.util.List;

/**
 * the interface of class which can cast photon to the scene
 * 
 * @author v-honzha
 */
public interface IPhotonCaster {
    List<PhotonHitInfo> castPhoton(Photon photon);
}
