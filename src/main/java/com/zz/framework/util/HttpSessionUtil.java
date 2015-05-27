package com.zz.framework.util;

import javax.servlet.http.HttpSession;

/**
 * Created by Alex.Zhang on 2015/5/26.
 */
public class HttpSessionUtil {

    public static final HttpSession getHttpSession() {
        return SpringContextUtil.getHttpRequest().getSession();
    }

    public static final String getSessionId() {
        return getHttpSession().getId();
    }

    public static final void setAttribute(final String key, final Object obj) {
        getHttpSession().setAttribute(key, obj);
    }

    public static final Object getAttribute(final String key) {
        return getHttpSession().getAttribute(key);
    }
}
