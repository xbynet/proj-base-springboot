package com.github.xbynet.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 *启动监听器,依赖于spring框架，监听ContextRefreshedEvent事件，可以在spring容器初始化后调用，
 */
@Service
public class StartListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null)//确保是root application context以防止重复调用的问题 (有个时候存在多个Spring上下文).  
        {   
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。   
			System.out.println("root application context started!");
        } 
	}

}
