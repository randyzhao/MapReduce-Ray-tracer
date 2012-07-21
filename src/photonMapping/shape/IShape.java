package photonMapping.shape;

import java.util.List;

import photonMapping.IDirected;
import photonMapping.PhotonHitInfo;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

public interface IShape extends IAxisScale{
	Vector getPosition();
	IMaterial getMaterial();
	List<PhotonHitInfo> getPhotonHitInformations();
	IntersectInfo intersect(IDirected directed);
}
