package com.github.xbynet.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@ImportResource("classpath:application-tx.xml")
public class CommonConfig {

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(
			EntityManagerFactory emf) {
		HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
		fact.setEntityManagerFactory(emf);
		return fact;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	//https://stackoverflow.com/questions/36979281/using-spring-boot-and-data-jpa-getting-lazyinitializationexception-despite-the
	@Bean
    public FilterRegistrationBean registerOpenSessionInViewFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        OpenSessionInViewFilter filter = new OpenSessionInViewFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(10);
        return registrationBean;
    }
}
