package com.ng.sample.sync;

import java.util.HashMap;
import java.util.Map;

/**
 * 同步的例子
 * @author  ZhengWei
 * @version 2013年11月18日下午1:55:29
 * @since   JDK1.6 
 */
public class SyncManager {

	private Object lockObj = new Object();
	
	private Map<Long, SyncLock> syncLockMap = new HashMap<Long, SyncLock>();
	
	private Map<Long, ParentEntity> parentEntityMap = new HashMap<Long, ParentEntity>();
	
	public SyncManager() {
		super();
	}
	
	public void add(SampleEntity entity) {
		SyncLock lock = null;
		synchronized (lockObj) {
			lock = syncLockMap.get(entity.getParentId());
			if (lock == null) {
				lock = new SyncLock();
				syncLockMap.put(entity.getParentId(), lock);
			}
			lock.refCount ++;
		}
		try {
			synchronized (lock) {
				ParentEntity parentEntity = parentEntityMap.get(entity.getParentId());
				if (parentEntity == null) {
					parentEntity = new ParentEntity(entity.getParentId());
				}
				parentEntity.addSampleEntity(entity);
			}
		} finally {
			if (lock != null) {
				lock.refCount --;
				if (lock.refCount == 0) {
					syncLockMap.remove(entity.getId());
				}
			}
		}
	}
	
}
