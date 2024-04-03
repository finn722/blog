package com.finn.blog.id.constants;

public class Constants {

    public static final String LEAF_SEGMENT_ENABLE = "leaf.segment.enable";
    public static final String LEAF_JDBC_URL = "leaf.jdbc.url";
    public static final String LEAF_JDBC_USERNAME = "leaf.jdbc.username";
    public static final String LEAF_JDBC_PASSWORD = "leaf.jdbc.password";

    public static final String LEAF_SNOWFLAKE_ENABLE = "leaf.snowflake.enable";
    public static final String LEAF_SNOWFLAKE_PORT = "leaf.snowflake.enable";
    public static final String LEAF_SNOWFLAKE_ZK_ADDRESS = "leaf.snowflake.zk.address";

    public static final String MASTER = "master";

    public static final String SLAVE = "slave";


    public static final String DRUID_DATASOURCE = "com.alibaba.druid.pool.DruidDataSource";

    /**
     * HikariCp数据源
     */
    public static final String HIKARI_DATASOURCE = "com.zaxxer.hikari.HikariDataSource";
    /**
     * BeeCp数据源
     */
    public static final String BEECP_DATASOURCE = "cn.beecp.BeeDataSource";
    /**
     * DBCP2数据源
     */
    public static final String DBCP2_DATASOURCE = "org.apache.commons.dbcp2.BasicDataSource";
    /**
     * Atomikos数据源
     */
    public static final String ATOMIKOS_DATASOURCE = "com.atomikos.jdbc.AtomikosDataSourceBean";







}
