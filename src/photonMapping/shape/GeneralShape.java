package photonMapping.shape;

import java.util.ArrayList;
import java.util.List;

import photonMapping.PhotonHitInformation;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;


public abstract class GeneralShape implements IShape {
	protected Vector position;
	protected IMaterial material;
	protected List<PhotonHitInformation> photonHitInformations = new ArrayList<PhotonHitInformation>();
	@Override
	public Vector getPosition() {
		return this.position;
	}

	@Override
	public IMaterial getMaterial() {
		return this.material;
	}

	@Override
	public List<PhotonHitInformation> getPhotonHitInformations() {
		return this.photonHitInformations;
	}

}
