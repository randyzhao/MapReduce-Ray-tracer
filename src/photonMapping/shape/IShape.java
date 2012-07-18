package photonMapping.shape;

import java.util.List;

import photonMapping.IntersectInfo;
import photonMapping.PhotonHitInformation;
import photonMapping.Ray;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

public interface IShape {
	Vector getPosition();

	IMaterial getMaterial();

	IntersectInfo intersect(Ray r);

	List<PhotonHitInformation> getPhotonHitInformations();
}
