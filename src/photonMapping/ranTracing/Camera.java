/**  
 * Filename:    Camera.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 8:25:17 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import photonMapping.Ray;
import photonMapping.Vector;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 22, 2012 8:25:17 PM
 */
public class Camera {
	/**
	 * the position of the camera
	 */
	private Vector position;
	/**
	 * the center point of the view port
	 */
	private Vector scene;
	/**
	 * the up direction of the view portt
	 */
	private Vector up;
	/**
	 * the right direction of the view port
	 */
	private Vector right;

	public Camera() {
	};

	public Camera(Vector position, Vector lookVector, Vector up) {
		this.position = position;
		this.scene = position.plus(lookVector);
		this.right = up.cross(lookVector.reverse()).normilize();
		this.up = lookVector.reverse().cross(this.right).normilize();
	}

	/**
	 * generate a ray from the camera to view port
	 * 
	 * @param xd
	 * @param yd
	 * @return the ray. The source is in view port
	 * @author Hongze Zhao
	 */
	public Ray getRay(double xd, double yd){
		Vector point = this.scene.minus(this.up.multiple(yd)).minus(this.right.multiple(xd));
		return new Ray(point, point.minus(this.position).normilize());
	}

	public Vector getPosition() {
		return this.position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getScene() {
		return this.scene;
	}

	public void setScene(Vector scene) {
		this.scene = scene;
	}

	public Vector getUp() {
		return this.up;
	}

	public void setUp(Vector up) {
		this.up = up;
	}

	public Vector getRight() {
		return this.right;
	}

	public void setRight(Vector right) {
		this.right = right;
	}
}

