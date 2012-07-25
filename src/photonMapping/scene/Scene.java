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

import photonMapping.lightSource.ILightSource;
import photonMapping.ranTracing.Camera;
import photonMapping.shape.IShape;

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
	private Camera camera;
	private Background background;

	public Background getBackground() {
		return this.background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

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

	public Camera getCamera() {
		return this.camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public static Scene testScene() {
		// TODO:
		return null;
	}

	public void addShape(IShape shape) {
		this.shapes.add(shape);
	}

}
