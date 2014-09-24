package com.otovc.dao.impl;

import java.util.List;
import java.util.Map;

import com.otovc.dao._BaseDao;
import com.otovc.system.DBUtils;
import com.otovc.system.DaoInterceptor;
import com.otovc.vo.PagerVo;

public class _BaseDaoImpl implements _BaseDao {

	private static _BaseDao baseDao;

	public static _BaseDao getInstance() {

		if (null == baseDao) {
			_BaseDaoImpl _original = new _BaseDaoImpl();

			baseDao = (_BaseDao) new DaoInterceptor(_original).create();
		}

		return baseDao;
	}

	protected DBUtils db = DBUtils.getInstance();

	@Override
	public void add(Object model) {
		db.getCurrentSession().insert(model.getClass().getName() + ".add", model);
	}

	@Override
	public void update(Class<?> clazz, Map<String, Object> params) {
		db.getCurrentSession().insert(clazz.getName() + ".update", params);
	}

	@Override
	public void deleteById(Class<?> clazz, int id) {
		db.getCurrentSession().delete(clazz.getName() + ".deleteById", id);
	}

	@Override
	public <T> T findById(Class<T> clazz, int id) {
		return db.getCurrentSession().selectOne(clazz.getName() + ".findById", id);
	}

	@Override
	public boolean exists(Class<?> clazz, Map<String, Object> params) {
		int num = db.getCurrentSession().selectOne(clazz.getName() + ".exists", params);

		return 0 == num ? false : true;
	}

	@Override
	public <T> PagerVo<T> listPager(Class<T> clazz, Map<String, Object> params) {
		List<T> datas = null;

		long totalItems = db.getCurrentSession().selectOne(clazz.getName() + ".countAll", params);

		if (0 != totalItems) {
			datas = db.getCurrentSession().selectList(clazz.getName() + ".listPager", params);

		}

		PagerVo<T> vo = new PagerVo<T>();
		vo.setTotalItems(totalItems);
		vo.setDatas(datas);

		return vo;
	}

}
