package com.otovc.system;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {

	private static DBUtils db;

	public static DBUtils getInstance() {
		if (null == db) {
			db = new DBUtils();
		}
		return db;
	}

	private static SqlSessionFactory factory;

	private DBUtils() {
		init();
	}

	private void init() {
		InputStream in = null;

		try {

			in = DBUtils.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml");

			factory = new SqlSessionFactoryBuilder().build(in);

		} finally {
			try {
				if (null != in) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public SqlSession openSession() {
		// 创建sqlSession
		SqlSession ss = factory.openSession();

		// 放入ThreadLocal
		SessionContext.setSession(ss);

		return ss;
	}

	public SqlSession getCurrentSession() {

		SqlSession ss = SessionContext.getSession();

		if (null == ss) {
			ss = openSession();
			SessionContext.setSession(ss);
		}

		return ss;
	}

	/**
	 * @see 查询语句无需提交，直接关闭
	 */
	public void closeCurrentSession() {
		getCurrentSession().close();
		SessionContext.removeSession();
	}

	public void closeCurrentSession(boolean needCommit) {
		if (needCommit) {
			commit();
		}
		closeCurrentSession();
	}

	public void commit() {

		getCurrentSession().commit();
	}

	public void rollback() {
		getCurrentSession().rollback();
	}
}
