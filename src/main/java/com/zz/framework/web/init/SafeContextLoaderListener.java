package com.zz.framework.web.init;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Created by Alex.Zhang on 2015/5/21.
 */
public class SafeContextLoaderListener implements ServletContextListener{

    private final Logger log = Logger.getLogger(getClass());

    private final ContextLoaderListener delegate = new ContextLoaderListener();

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        try{
            this.delegate.contextInitialized(servletContextEvent);
        }catch (Throwable t) {
            final String message = "框架的Spring ContextLoaderListener初始化异常,spring context将初始化失败!";

            log.error(message, t);
            System.err.println(message);
            t.printStackTrace();

            ServletContext servletContext = servletContextEvent.getServletContext();
            servletContext.log(message, t);
        }
    }

    @Override
    public void contextDestroyed(final ServletContextEvent servletContextEvent) {
        this.delegate.contextDestroyed(servletContextEvent);
    }
}
