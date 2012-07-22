package photonMapping.shape;

import photonMapping.Color;
import photonMapping.IDirected;
import photonMapping.Vector;
import photonMapping.materials.IMaterial;

public class IntersectInfo {
	private boolean isHit;
	private Vector position;
	/**
	 * normal vector of the hit position
	 */
	private Vector normal;
	private double distance;
	private IDirected directed;
	private IShape content;
	private Color color;
	private IMaterial material;
	public IntersectInfo(){
		this.isHit = false;
	}

	public IntersectInfo(Vector position, Vector normal,
			double distance,
			IDirected directed, IShape content, Color color) {
		this.isHit = true;
		this.position = position;
		this.normal = normal;
		this.distance = distance;
		this.directed = directed;
		this.content = content;
		this.color = color;
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

	public IShape getContent() {
		return this.content;
	}

	public void setContent(IShape content) {
		this.content = content;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vector getNormal() {
		return this.normal;
	}

	public IDirected getDirected() {
		return this.directed;
	}

	public IMaterial getMaterial() {
		return this.material;
	}

	public void setMaterial(IMaterial material) {
		this.material = material;
	}
}
