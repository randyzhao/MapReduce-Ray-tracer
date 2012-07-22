/**  
 * Filename:    GeneralPhotonCaster.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 8:23:03 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.photonCast;

import java.util.LinkedList;
import java.util.List;

import photonMapping.Photon;
import photonMapping.PhotonHitInfo;
import photonMapping.materials.IMaterial;
import photonMapping.scene.Scene;
import photonMapping.shape.IShape;
import photonMapping.shape.IntersectInfo;

/**
 *
 * @author Hongze Zhao
 * Create At : Jul 21, 2012 8:23:03 PM
 */
public class GeneralPhotonCaster implements IPhotonCaster {

	private Scene scene;
	private List<IShape> shapes;
	public GeneralPhotonCaster(Scene scene) {
		this.scene = scene;
		this.shapes = scene.getShapes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * photonMapping.photonCast.IPhotonCaster#castPhoton(photonMapping.Photon)
	 */
	@Override
	public List<PhotonHitInfo> castPhoton(Photon photon) {
		double nearestDist = Double.MAX_VALUE;
		IntersectInfo nearestII = null;
		for (IShape shape : this.shapes) {
			IntersectInfo ii = shape.intersect(photon);
			if (ii.isHit() && ii.getDistance() < nearestDist) {
				nearestDist = ii.getDistance();
				nearestII = ii;
			}

		}
		if (nearestII != null) {
			return this.handleIntersectInfo(photon, nearestII);
		} else {
			return null;
		}
	}

	/**
	 * handle the intersectInfo when find the nearest shape that the photon will
	 * hit
	 * 
	 * @param ii
	 * @return
	 * @author Hongze Zhao
	 */
	private List<PhotonHitInfo> handleIntersectInfo(Photon photon,
			IntersectInfo ii) {
		List<PhotonHitInfo> photonHitInfos = new LinkedList<PhotonHitInfo>();
		IShape shape = (IShape)ii.getContent();
		IMaterial material = shape.getMaterial();
		//assume all the surface are diffuse surface now
		//TODO: add handlers to other type of surface
		photonHitInfos.add(new PhotonHitInfo(photon.getColor(), ii
				.getPosition(), photon.getDirection()));
		return photonHitInfos;
	}

}
