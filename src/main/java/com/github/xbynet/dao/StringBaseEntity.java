package com.github.xbynet.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义String类型id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 * uuid
 */
//JPA 基类的标识
@MappedSuperclass
public abstract class StringBaseEntity extends BaseEntity{

	protected String id;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if("".equals(id))
		{
			id = null;
		}
		this.id = id;
	}
}
