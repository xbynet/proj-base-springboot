package com.github.xbynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@ServletComponentScan(basePackages = {"com.github.xbynet.config"})
@EnableJpaRepositories(basePackages={"com.github.xbynet.**.dao"})
@ComponentScan(basePackages = { "com.github.xbynet.**.controller","com.github.xbynet.**.mvc","com.github.xbynet.**.service","com.github.xbynet.**.dao","com.github.xbynet.**.config"})
@EntityScan(basePackages={"com.github.xbynet.**.entity"})
public class Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}