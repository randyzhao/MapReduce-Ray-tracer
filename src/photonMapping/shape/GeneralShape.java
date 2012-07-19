package photonMapping.shape;

import java.util.ArrayList;
import java.util.List;

import photonMapping.PhotonHitInformation;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;


public abstract class GeneralShape implements IShape{
	protected Vector position;
	protected IMaterial material;
	protected List<PhotonHitInformation> photonHitInformations = new ArrayList<PhotonHitInformation>();
	public Vector getPosition() {
		return position;
	}
	public IMaterial getMaterial() {
		return material;
	}
	public List<PhotonHitInformation> getPhotonHitInformations() {
		return photonHitInformations;
	}

}
