package photonMapping.shape;

import photonMapping.IDirected;
import photonMapping.Vector;

public class IntersectInfo {
	private boolean isHit;
	private Vector position;
	/**
	 * normal vector of the hit position
	 */
	private Vector normal;
	private double distance;
	private IDirected directed;
	private Object content;
	public IntersectInfo(){
		this.isHit = false;
	}

	public IntersectInfo(Vector position, Vector normal,
			double distance, IDirected directed, Object content) {
		this.isHit = true;
		this.position = position;
		this.normal = normal;
		this.distance = distance;
		this.directed = directed;
		this.content = content;
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

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
