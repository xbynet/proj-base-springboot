package com.github.xbynet.config;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;





/**
 *启动监听器,依赖于sevlet容器
 */
@Component
public class ServletListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent cd) {

	}

	public void contextInitialized(ServletContextEvent sce) {

		String rootPath = new File(sce.getServletContext().getRealPath("/")).getParent();
		GlobalContext.setRootPath(rootPath);
	}
}
