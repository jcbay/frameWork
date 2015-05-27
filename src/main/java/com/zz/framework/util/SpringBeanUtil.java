package com.zz.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Alex.Zhang on 2015/5/26.
 */
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext ctx;

    public static <T> T getBean(Class<T> aClass) {
        return ctx.getBean(aClass);
    }

    public static <T> T getBean(final String beanName, Class<T> aClass) {
        return ctx.getBean(beanName, aClass);
    }

    public static Object getBean(final String beanName) {
        return ctx.getBean(beanName);
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
