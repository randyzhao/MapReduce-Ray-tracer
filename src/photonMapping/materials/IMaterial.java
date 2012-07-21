package photonMapping.materials;

import photonMapping.Color;

public interface IMaterial {
	double getReflection();

	/**
	 * the ratio of refraction
	 * 
	 * @return [0, 1]
	 * @author Hongze Zhao
	 */
	double getRefraction();

	double getRefractivity();

	Color getColor();

}
