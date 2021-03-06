/**  
 * Filename:    KDTree.java  
 * Description:   
 * Copyright:   Copyright (c)2011 
 * Company:    company 
 * @author:     Hongze Zhao 
 * @version:    1.0  
 * Create at:   Jul 21, 2012 3:04:50 PM  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * Jul 21, 2012    Hongze Zhao   1.0         1.0 Version  
 */
package photonMapping.DataStructure;

import java.util.List;

import photonMapping.shape.BoundingVolumn;
import photonMapping.shape.ExtendedPlain;
import photonMapping.shape.IAxisScale;

/**
 * 
 * @author Hongze Zhao Create At : Jul 21, 2012 3:04:50 PM
 */
public class KDTree<T extends IAxisScale> {

	public enum KDTreeSeperateMethodEnum {
		XAxis, YAxis, ZAxis
	}

	protected boolean leaf;
	protected KDTree<T> leftChild;
	protected KDTree<T> rightChild;
	protected BoundingVolumn boundingVolumn;
	protected ExtendedPlain seperatePlain;
	protected KDTreeSeperateMethodEnum seperateMethod;
	protected List<T> contents;

	public boolean isLeaf() {
		return this.leaf;
	}

	public KDTree<T> getLeftChild() {
		return this.leftChild;
	}

	public KDTree<T> getRightChild() {
		return this.rightChild;
	}

	public BoundingVolumn getBoundingVolumn() {
		return this.boundingVolumn;
	}

	public KDTreeSeperateMethodEnum getSeperateMethod() {
		return this.seperateMethod;
	}

	public List<T> getContents() {
		return this.contents;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public void setLeftChild(KDTree<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(KDTree<T> rightChild) {
		this.rightChild = rightChild;
	}





}
