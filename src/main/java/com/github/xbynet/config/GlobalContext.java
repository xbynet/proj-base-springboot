package com.github.xbynet.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.github.xbynet.util.StringUtil;

@Component
public class GlobalContext implements ApplicationContextAware {

	private static ApplicationContext ac;
	private static BeanDefinitionRegistry beanDefinitonRegistry;
	private static String rootPath;

	public static ApplicationContext getAc() {
		return ac;
	}

	public static void setAc(ApplicationContext ac) {
		GlobalContext.ac = ac;
	}

	public static String getRootPath() {
		return rootPath;
	}

	public static void setRootPath(String rootPath) {
		GlobalContext.rootPath = rootPath;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ac = applicationContext;
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ac;
		beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
				.getBeanFactory();
	}

	public static Object getBean(String name) {
		return ac.getBean(name);
	}

	public static <T> T getBean(Class<T> clz) {
		return ac.getBean(clz);
	}

	public static <T> T getBean(String name, Class<T> clz) {
		return ac.getBean(name, clz);
	}
	/**
     * 动态注册bean
     * @param beanName
     * @param beanDefinition
     */
    public synchronized static void registerBean(String beanName, BeanDefinition beanDefinition){
    	//DefaultListableBeanFactory beanDefinitonRegistry = (DefaultListableBeanFactory) app.getAutowireCapableBeanFactory();
    	if(!beanDefinitonRegistry.containsBeanDefinition(beanName)){
    	  beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
    	}
    }
    public static void registerBean(BeanDefinition beanDefinition){
    	//DefaultListableBeanFactory beanDefinitonRegistry = (DefaultListableBeanFactory) app.getAutowireCapableBeanFactory();
    	String simpleNameString=beanDefinition.getBeanClassName();
    	if(simpleNameString.contains(".")){
    		simpleNameString=simpleNameString.substring(simpleNameString.lastIndexOf(".")+1);
    	}
    	simpleNameString=StringUtil.lowerFirstChar(simpleNameString);
    	registerBean(simpleNameString,beanDefinition);
    }
    public static BeanDefinitionBuilder getBeanDefinitionBuilder(Class clazz){
    	return BeanDefinitionBuilder.genericBeanDefinition(clazz);
//        beanDefinitionBuilder.addPropertyValue("xxx", xxx);
//        beanDefinitionBuilder.setInitMethodName("init");
//        beanDefinitionBuilder.setDestroyMethodName("destroy");
    }
}