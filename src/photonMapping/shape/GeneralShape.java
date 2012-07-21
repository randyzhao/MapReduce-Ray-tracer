package photonMapping.shape;

import java.util.ArrayList;
import java.util.List;

import photonMapping.PhotonHitInfo;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;


public abstract class GeneralShape implements IShape{
	protected Vector position;
	protected IMaterial material;
	protected List<PhotonHitInfo> photonHitInformations = new ArrayList<PhotonHitInfo>();
	public Vector getPosition() {
		return position;
	}
	public IMaterial getMaterial() {
		return material;
	}
	public List<PhotonHitInfo> getPhotonHitInformations() {
		return photonHitInformations;
	}

}
