package com.ng.sample.sync;

import java.util.ArrayList;
import java.util.List;

public class ParentEntity {

	private long id;
	
	private List<SampleEntity> ses = new ArrayList<SampleEntity>();
	
	public ParentEntity() {
		super();
	}

	public ParentEntity(long id) {
		this();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SampleEntity> getSes() {
		return ses;
	}

	public void setSes(List<SampleEntity> ses) {
		this.ses = ses;
	}
	
	public void addSampleEntity(SampleEntity se) {
		this.ses.add(se);
	}
	
	public SampleEntity getSampleEntity(long sampleEntityId) {
		for (int i = this.getSes().size() - 1; i >= 0; i --) {
			SampleEntity se = this.getSes().get(i);
			if (se.getId() == sampleEntityId) {
				return se;
			}
		}
		return null;
	}
	
}
