
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
		this.bound();
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

	public void bound() {
		this.red = Math.min(this.red, 1);
		this.green = Math.min(this.green, 1);
		this.blue = Math.min(this.blue, 1);
	}

	public Color multiple(double f) {
		Color out = new Color(this.red * f, this.green * f, this.blue * f);
		out.bound();
		return out;
	}

	public Color multiple(Color col) {
		return new Color(this.red * col.red, this.green * col.green, this.blue
				* col.blue);
	}

	public Color plus(Color color) {
		Color out = new Color(this.red + color.red, this.green + color.green,
				this.blue + color.blue);
		out.bound();
		return out;
	}

	public Color blend(Color b, double weight) {
		Color output = this.multiple(1 - weight);
		output.plus(b.multiple(weight));
		output.bound();
		return output;
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
