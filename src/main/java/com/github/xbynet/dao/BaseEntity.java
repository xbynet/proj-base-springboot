package com.github.xbynet.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 * @author xby taojw
 *
 */
@MappedSuperclass
public abstract  class BaseEntity implements Serializable{
	protected Date insertTime;
	protected Date updateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)  
	@CreationTimestamp
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
