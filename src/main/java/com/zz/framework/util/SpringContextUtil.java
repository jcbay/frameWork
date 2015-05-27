package com.zz.framework.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alex.Zhang on 2015/5/26.
 */
public class SpringContextUtil {

    private SpringContextUtil(){}

    public static final HttpServletRequest getHttpRequest() {
        return ((ServletWebRequest)RequestContextHolder.getRequestAttributes())
                .getRequest();
    }

    public static final HttpServletResponse getHttpResponse() {
        return ((ServletWebRequest)RequestContextHolder.getRequestAttributes())
                .getResponse();
    }

}
