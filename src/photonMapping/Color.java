
package photonMapping;

import java.util.Iterator;
import java.util.List;

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

	public int toIntValue() {
		int rgb = (int) (this.red * 256);
		rgb = (rgb << 8) + (int) (this.green * 256);
		rgb = (rgb << 8) + (int) (this.blue * 256);
		return rgb;
	}
	public static Color BLACK(){
		return new Color(0, 0, 0);
	}

	// TODO
	public void clear() {

	}

	public double getRed() {
		return this.red;
	}

	public double getBlue() {
		return this.blue;
	}

	public double getGreen() {
		return this.green;
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

	public static Color averageColor(List<Color> colors) {
		if (colors == null) {
			return new Color(0, 0, 0);
		}
		Iterator<Color> ci = colors.iterator();
		double r = 0;
		double g = 0;
		double b = 0;
		while (ci.hasNext()) {
			Color color = ci.next();
			r += color.getRed();
			g += color.getGreen();
			b += color.getBlue();
		}
		int size = colors.size();
		return new Color(r / size, g / size, b / size);

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
