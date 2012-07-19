package photonMapping.shape;

import java.util.List;

import photonMapping.IDirected;
import photonMapping.PhotonHitInformation;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

public interface IShape extends IAxisScale{
	Vector getPosition();
	IMaterial getMaterial();
	List<PhotonHitInformation> getPhotonHitInformations();
	IntersectInformation intersect(IDirected directed);
}
