package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;

public class IntersectInformation {
	private boolean isHit;
	private Vector position;
	/**
	 * normal vector of the hit position
	 */
	private Vector normal;
	private double distance;
	private IDirected directed;

	public IntersectInformation(){
		this.isHit = false;
	}
	public IntersectInformation(Vector position, Vector normal, double distance, IDirected directed){
		this.isHit = true;
		this.position = position;
		this.normal = normal;
		this.distance = distance;
		this.directed = directed;
	}
	public boolean isHit() {
		return this.isHit;
	}
	public Vector getPosition() {
		return this.position;
	}
	public double getDistance() {
		return this.distance;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public void setNormal(Vector normal) {
		this.normal = normal;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setDirected(IDirected directed) {
		this.directed = directed;
	}

}
