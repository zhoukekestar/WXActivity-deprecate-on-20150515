package com.otovc.system;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.ibatis.session.SqlSession;

/**
 * @see 自动打开，自动提交，自动关闭session
 * @author Administrator
 * 
 */
public class DaoInterceptor implements MethodInterceptor {

	private Object original;

	public DaoInterceptor(Object _original) {
		original = _original;
	}

	public Object create() {
		Enhancer enhancer = new Enhancer();

		// 使用继承方式实现动态代理(父类)
		enhancer.setSuperclass(this.original.getClass());

		enhancer.setCallback(this);

		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		String methodName = method.getName();

		if (methodName.startsWith("add") || methodName.startsWith("update") || methodName.startsWith("delete")) {
			return invoke_dml(method, args);

		} else {
			return invoke_select(method, args);
		}
	}

	/**
	 * @see 如果是数据控制语句，调用此方法
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	private Object invoke_dml(Method method, Object[] args) throws Throwable {
		Object obj = null;
		SqlSession ss = null;
		try {

			synchronized (this) {
				// 执行被代理方法
				obj = method.invoke(original, args);

			}

			ss = SessionContext.getSession();

			if (null != ss) {
				ss.commit();
			}

		} catch (Exception e) {
			// 事务回滚
			if (null != SessionContext.getSession()) {
				SessionContext.getSession().rollback();
			}

			e.printStackTrace();

		} finally {

			ss = SessionContext.getSession();

			if (null != ss) {
				ss.close();
				SessionContext.removeSession();
			}
		}
		return obj;
	}

	/**
	 * @see 查询语句调用此方法
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	private Object invoke_select(Method method, Object[] args) throws Throwable {

		Object obj = null;
		SqlSession ss = null;
		try {

			obj = method.invoke(original, args);

		} finally {
			if (null != (ss = SessionContext.getSession())) {
				SessionContext.removeSession();
				ss.close();
			}
		}

		return obj;

	}

}
