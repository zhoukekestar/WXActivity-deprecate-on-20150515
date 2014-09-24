package com.otovc.dao;

import java.util.Map;

import com.otovc.vo.PagerVo;

public interface _BaseDao {

	void add(Object model);

	void update(Class<?> clazz, Map<String, Object> params);

	void deleteById(Class<?> clazz, int id);

	<T> T findById(Class<T> clazz, int id);

	boolean exists(Class<?> clazz, Map<String, Object> params);

	<T> PagerVo<T> listPager(Class<T> clazz, Map<String, Object> params);

}
