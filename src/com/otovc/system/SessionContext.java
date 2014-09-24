package com.otovc.system;

import org.apache.ibatis.session.SqlSession;

public class SessionContext {

	private static ThreadLocal<SqlSession> session;

	static {
		session = new ThreadLocal<SqlSession>();
	}

	public static SqlSession getSession() {
		return session.get();
	}

	public static void setSession(SqlSession session) {
		SessionContext.session.set(session);
	}

	public static void removeSession() {
		session.remove();
	}

}
