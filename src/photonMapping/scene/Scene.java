/**  
 * Filename:    Scene.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 8:34:37 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.scene;

import java.util.ArrayList;
import java.util.List;

import photonMapping.Color;
import photonMapping.Vector;
import photonMapping.lightSource.DotLightSource;
import photonMapping.lightSource.ILightSource;
import photonMapping.materials.DiffuseMaterial;
import photonMapping.shape.IShape;
import photonMapping.shape.Sphere;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 8:34:37 PM
 */
public class Scene {
	/**
	 * only support single light source
	 */
	private ILightSource lightSource;
	private List<IShape> shapes = new ArrayList<IShape>();

	public ILightSource getLightSource() {
		return this.lightSource;
	}

	public void setLightSource(ILightSource lightSource) {
		this.lightSource = lightSource;
	}

	public List<IShape> getShapes() {
		return this.shapes;
	}

	public void setShapes(List<IShape> shapes) {
		this.shapes = shapes;
	}

	public static Scene testScene() {
		Scene scene = new Scene();
		scene.shapes.add(new Sphere(5, new Vector(0, 0, 0),
				new DiffuseMaterial(0.5, new Color(1, 0, 0))));
		scene.lightSource = new DotLightSource(new Vector(5, 5, 5), new Color(
				0, 1, 0));
		return scene;
	}

}
