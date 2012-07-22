package photonMapping.materials;

import photonMapping.Color;

public interface IMaterial {
	double getReflection();

	/**
	 * the gloss of a material
	 * 
	 * @return in [0, 1]
	 * @author Hongze Zhao
	 */
	double getGloss();

	/**
	 * the ratio of refraction
	 * 
	 * @return [0, 1]
	 * @author Hongze Zhao
	 */
	double getRefraction();

	/**
	 * the trasparency of a material
	 * 
	 * @return in [0, 1]
	 * @author Hongze Zhao
	 */
	double getTransparency();

	boolean has2DTexture();
	/**
	 * get material's color in the given position
	 * 
	 * @param u
	 * @param v
	 * @return
	 * @author Hongze Zhao
	 */
	Color getColor(double u, double v);

}
