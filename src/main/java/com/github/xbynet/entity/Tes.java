package com.github.xbynet.entity;

import com.github.xbynet.dao.StringBaseEntity;

import javax.persistence.Entity;

/**
 * @author taojiawei
 * @create 2018/1/8
 **/
@Entity
public class Tes extends StringBaseEntity{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
