package com.otovc.dao.impl;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.otovc.dao._BaseDao;
import com.otovc.model.User;
import com.otovc.model.UserShareLog;

public class _BaseDaoImplTest {

	private _BaseDao baseDao = _BaseDaoImpl.getInstance();

	@Test
	public void testAdd() {

		User m1 = new User();
		m1.setOpenid("asdfasdfaefasdf");
		m1.setNickname("张三");
		m1.setImgurl("www.baidu.com/");
		m1.setCode(123456);
		m1.setCreated(new Date());

		UserShareLog m2 = new UserShareLog();
		m2.setFromid(1);
		m2.setToid(2);
		m2.setCreated(new Date());

		baseDao.add(m1);
		baseDao.add(m2);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPager() {
		fail("Not yet implemented");
	}

}
