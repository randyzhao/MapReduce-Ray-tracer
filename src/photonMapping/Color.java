
package photonMapping;

/**
 * specifies the r, g, b color which can speed up the render process all r, g, b
 * should be in [0, 1]
 * 
 * @author Hongze Zhao Create At : Jul 19, 2012 1:07:18 AM
 */
public class Color {

	/**
	 * in [0, 1]
	 */
	private double red;
	/**
	 * in [0, 1]
	 */
	private double blue;
	/**
	 * in [0, 1]
	 */
	private double green;

	public Color() {
		this.red = this.blue = this.green = 0;
	}

	public Color(double red, double blue, double green) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public static Color BLACK(){
		return new Color(0, 0, 0);
	}

	// TODO
	public void clear() {

	}

	// TODO
	public void fromFormatString(String input) {
		this.clear();
	}

	// TODO
	public String asFormatString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		sb.append(this.red).append(',').append(this.green).append(',')
				.append(this.blue);
		sb.append(')');
		return sb.toString();
	}

}
