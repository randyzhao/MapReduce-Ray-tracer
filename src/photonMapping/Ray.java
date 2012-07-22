
package photonMapping;

public class Ray implements IDirected {
	private Vector position;
	private Vector direction;

	public Ray(Vector position, Vector direction) {
		this.position = position;
		this.direction = direction;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.IDirected#getSourcePosition()
	 */
	@Override
	public Vector getPosition() {
		return this.position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.IDirected#getDirection()
	 */
	@Override
	public Vector getDirection() {
		return this.direction;
	}

}
