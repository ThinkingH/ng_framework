package com.ng.sample.sync;

/**
 * 样本实体
 * @author  ZhengWei
 * @version 2013年11月18日下午1:59:43
 * @since   JDK1.6 
 */
public class SampleEntity {

	private long id;
	
	private long parentId;
	
	public SampleEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
}
