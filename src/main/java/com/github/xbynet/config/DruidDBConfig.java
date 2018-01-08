/*
package com.github.xbynet.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
*/
/**
 * Druid的DataResource配置类 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment
 * 可以在工程启动时， 获取到系统环境变量和application配置文件中的变量。
 * 还有一种方式是采用注解的方式获取 @value("${变量的key值}") 获取application配置文件中的变量。 这里采用第一种要方便些
 *//*

public class DruidDBConfig {

	@Bean
//	@ConfigurationProperties("spring.datasource.*")
	public DruidDataSource dataSource(DataSourceProperties properties) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(properties.determineDriverClassName());
		dataSource.setUrl(properties.determineUrl());
		dataSource.setUsername(properties.determineUsername());
		dataSource.setPassword(properties.determinePassword());

		DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
		String validationQuery = databaseDriver.getValidationQuery();
		if (validationQuery != null) {
			dataSource.setTestOnBorrow(true);
			dataSource.setValidationQuery(validationQuery);
		}
		try {
			// 开启Druid的监控统计功能，mergeStat代替stat表示sql合并,wall表示防御SQL注入攻击
			dataSource.setInitialSize(5);
			dataSource.setMinIdle(5);
			dataSource.setMaxActive(20);
			dataSource.setMaxWait(60000);
			dataSource.setFilters("mergeStat,wall,log4j");
			dataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;

	}

	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("loginUsername", "druid");// 用户名
		initParameters.put("loginPassword", "druid");// 密码
		initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
		// initParameters.put("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
		// initParameters.put("deny", "192.168.20.38");// IP黑名单
		// (存在共同时，deny优先于allow)
		servletRegistrationBean.setInitParameters(initParameters);
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

	// 按照BeanId来拦截配置 用来bean的监控
	// @Bean(value = "druid-stat-interceptor")
	public DruidStatInterceptor druidStatInterceptor() {
		DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
		return druidStatInterceptor;
	}

	// @Bean(value="druid-stat-pointcut")
	public JdkRegexpMethodPointcut jdkRegexpMethodPointcut() {
		JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();

		jdkRegexpMethodPointcut.setPatterns(new String[] { "com.vsoontech.controller.*", "com.vsoontech.service.*" });

		return jdkRegexpMethodPointcut;
	}

	@Bean 
	public Advisor druidStatAdvisor() {
		return new DefaultPointcutAdvisor(jdkRegexpMethodPointcut(), druidStatInterceptor());
	}
	*/
/*
	 * @Bean public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
	 * BeanNameAutoProxyCreator beanNameAutoProxyCreator = new
	 * BeanNameAutoProxyCreator();
	 * beanNameAutoProxyCreator.setProxyTargetClass(true); // 设置要监控的bean的id
	 * //beanNameAutoProxyCreator.setBeanNames("sysRoleMapper","loginController"
	 * );
	 * beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");
	 * return beanNameAutoProxyCreator; }
	 *//*


}*/
