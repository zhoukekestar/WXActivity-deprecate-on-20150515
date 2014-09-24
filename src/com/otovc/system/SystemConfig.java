package com.otovc.system;

public class SystemConfig {

	/**
	 * 分页偏移量默认值
	 */
	public static final int DEFAULT_OFFSET = 0;

	/**
	 * 分页每页最大数默认值
	 */
	public static final int DEFAULT_PAGESIEZ = 5;

	/**
	 * where 条件语句 or 连接最大条数，(id=1 or id = 2 .... )
	 */
	public static final int MAX_WHERE_OR_NO = 100;

	/**
	 * 特殊表连接SQLmapper的映射路径
	 */
	public static final String BACKEND_MAPPER = "com.otovc.dataDefinition.TableJoinQuery";

	/**
	 * type、 status等 默认查全部，的入参值
	 */
	public static final int DEFAULT_ALL = -1;

}
