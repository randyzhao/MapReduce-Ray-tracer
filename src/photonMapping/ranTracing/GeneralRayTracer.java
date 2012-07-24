/**  
 * Filename:    GeneralRayTracer.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 22, 2012 10:32:07 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 22, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.ranTracing;

import photonMapping.Color;
import photonMapping.Ray;
import photonMapping.RayHitInfo;
import photonMapping.Vector;
import photonMapping.lightSource.ILightSource;
import photonMapping.scene.Scene;
import photonMapping.shape.IShape;
import photonMapping.shape.IntersectInfo;

/**
 * 
 * @author Hongze Zhao Create At : Jul 22, 2012 10:32:07 PM
 */
public class GeneralRayTracer implements IRayTracer {
	private Scene scene;
	private int renderDepth;

	public GeneralRayTracer(Scene scene, int renderDepth) {
		this.scene = scene;
		this.renderDepth = renderDepth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see photonMapping.ranTracing.IRayTracer#rayTrace(double, double, int)
	 */
	@Override
	public RayHitInfo rayTrace(double xd, double yd) {
		return this.calculateColor(xd, yd);
	}

	private RayHitInfo calculateColor(double xd, double yd) {
		Ray ray = this.scene.getCamera().getRay(xd, yd);
		IntersectInfo ii = this.getIntersectInfo(ray);
		Color col = null;
		if (ii.isHit()) {
			col = this.render(ray, ii, 0);
		} else {
			col = this.scene.getBackground().getColor();
		}
		return new RayHitInfo(xd, yd, col);
	}

	private IntersectInfo getIntersectInfo(Ray ray) {
		IntersectInfo ii = new IntersectInfo();
		double minDis = Double.MAX_VALUE;
		for (IShape shape : this.scene.getShapes()) {
			IntersectInfo tempii = shape.intersect(ray);
			if (tempii.isHit() && tempii.getDistance() < minDis) {
				minDis = tempii.getDistance();
				ii = tempii;
			}
		}
		return ii;
	}

	private Color render(Ray ray, IntersectInfo info, int depth) {
		Color output = this.phongRender(ray, info);
		if (depth < this.renderDepth){
			//reflection
			if (info.getContent().getMaterial().getReflection() > 0){
				Ray ref = this.getReflectionRay(info.getPosition(), info.getNormal(), ray.getDirection());
				IntersectInfo refInfo = this.getIntersectInfo(ray);
				Color refColor = new Color();
				if (refInfo.isHit()){
					refColor = this.render(ray, refInfo, depth + 1);
				}else{
					refColor = this.scene.getBackground().getColor();
				}
				output = output.blend(refColor, info.getMaterial()
						.getReflection());
			}
		}
		return output;
		// TODO:finish refraction
	}

	private Color phongRender(Ray ray, IntersectInfo info) {
		//ambiance
		Color output = info.getColor().multiple(this.scene.getBackground().getAmbiance());
		ILightSource ls = this.scene.getLightSource();
		Vector l = ls.getPosition().minus(info.getPosition());
		IntersectInfo ii = this.getIntersectInfo(new Ray(info.getPosition(), l));
		if (!(ii.isHit() && ii.getDistance() < l.magnitude())){//not in the shadow of the light source
			//diffuse light
			output = output.plus(ls.getColor().multiple(info.getColor()).multiple(l.normilize().multiple(info.getNormal())));
			//high light
			Ray refRay = this.getReflectionRay(info.getPosition(), info.getNormal(), l.normilize());
			double temp = refRay.getDirection().multiple(ray.getDirection());
			if (temp > 0){
				output.plus(ls.getColor().multiple(
						info.getMaterial().getGloss() * Math.pow(temp, 15)));
			}
		}
		return output;
	}

	/**
	 * 
	 * @param p
	 * @param n
	 * @param v
	 * @return
	 * @author Hongze Zhao
	 */
	private Ray getReflectionRay(Vector p, Vector n, Vector v) {
		double c1 = -n.dot(v);
		Vector r1 = v.plus(n.multiple(2).multiple(c1));
		return new Ray(p, r1);
	}
}
