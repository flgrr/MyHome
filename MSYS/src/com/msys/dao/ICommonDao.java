package com.msys.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.msys.domain.Tests;

public interface ICommonDao<T>{
	public	void save(T entity);
	public void update(T entity);
	public   T findObjectById(Serializable i);
	public  void deleteByIDs(Serializable[] ids);
	public  void deleteByCollection(List<T> list);
	public  List<T> findObjectByConditionNoPage(String condition, Object[] params,
			LinkedHashMap<String, String> orderby);

}
