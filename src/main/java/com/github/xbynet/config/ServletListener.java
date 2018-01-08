package com.github.xbynet.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;





/**
 *启动监听器,依赖于sevlet容器
 */
@WebListener
public class ServletListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent cd) {

	}

	public void contextInitialized(ServletContextEvent sce) {

		String rootPath = new File(sce.getServletContext().getRealPath("/")).getParent();
		System.out.println(rootPath);
		GlobalContext.setRootPath(rootPath);
	}
}
