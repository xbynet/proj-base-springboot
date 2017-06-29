package com.github.xbynet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ServletComponentScan(basePackages = {"com.github.xbynet.web"})  //@WebServlet, @WebFilter, and @WebListener扫描
//@EnableJpaRepositories(basePackages={"com.vsoontech.dao"}) spring-data处理 @Repository注解的，这里没用到Spring-data来作为持久层抽象
@ComponentScan
@EntityScan(basePackages={"com.github.xbynet.entity"})
public class Application {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
