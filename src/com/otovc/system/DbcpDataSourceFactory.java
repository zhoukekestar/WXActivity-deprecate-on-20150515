package com.otovc.system;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

public class DbcpDataSourceFactory implements DataSourceFactory {

	private static DataSource ds;

	public DbcpDataSourceFactory() {
		init();
	}

	private void init() {
		try {

			Properties prop = new Properties();
			prop.load(DbcpDataSourceFactory.class.getClassLoader().getResourceAsStream("db_dbcp.properties"));

			ds = BasicDataSourceFactory.createDataSource(prop);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DataSource getDataSource() {
		return ds;
	}

	@Override
	public void setProperties(Properties args) {

	}

}
