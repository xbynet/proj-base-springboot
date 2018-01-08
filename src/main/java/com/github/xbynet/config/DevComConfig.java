package com.github.xbynet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * for sqlite
 * @author taojiawei
 * @create 2018/1/8
 **/
@Configuration
@Profile("dev")
public class DevComConfig {
	/*@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.sqlite.JDBC");
		dataSourceBuilder.url("jdbc:sqlite:" + "example.db");
		dataSourceBuilder.type(SQLiteDataSource.class);
		return dataSourceBuilder.build();
	}*/


}
