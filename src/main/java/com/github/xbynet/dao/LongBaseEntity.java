package com.github.xbynet.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author taojiawei
 * @create 2018/1/8
 **/
public class LongBaseEntity extends BaseEntity {

	protected Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
