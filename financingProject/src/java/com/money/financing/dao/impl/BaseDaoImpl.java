package com.money.financing.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.money.financing.dao.IBaseDao;

public abstract class BaseDaoImpl<E, PK extends Serializable> implements
		IBaseDao<E, PK> {

	@Resource(name = "sqlMapClientTemplate")
	protected SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public abstract Class getEntityClass();

}
