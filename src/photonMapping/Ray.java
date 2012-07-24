
package photonMapping;


public class Ray implements IDirected {
	private Vector position;
	private Vector direction;

	public Ray(Vector position, Vector direction) {
		this.position = position;
		this.direction = direction;
	}

	public Ray(String inputStr) {
		this.fromFormatString(inputStr);
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



	public void fromFormatString(String input) {
		String[] ss = input.split(",");
		this.position = new Vector(Double.parseDouble(ss[0]),
				Double.parseDouble(ss[1]), Double.parseDouble(ss[2]));
		this.direction = new Vector(Double.parseDouble(ss[3]),
				Double.parseDouble(ss[4]), Double.parseDouble(ss[5]));
	}

	public String asFormatString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.position.getX()).append(",")
		.append(this.position.getY()).append(",")
		.append(this.position.getZ()).append(",");
		sb.append(this.direction.getX()).append(",")
		.append(this.direction.getY()).append(",")
		.append(this.direction.getZ());
		return sb.toString();
	}

}
