package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

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
		return isHit;
	}
	public Vector getPosition() {
		return position;
	}
	public double getDistance() {
		return distance;
	}
	
}
