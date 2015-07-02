package com.zz.framework.web.init;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by Alex.Zhang on 2015/5/25.
 */
public final class SafeDispatcherServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(getClass());

    private DispatcherServlet delegate = new DispatcherServlet();

    private boolean initSuccess = true;

    @Override
    public void destroy() {
        delegate.destroy();
    }

    @Override
    public void init(ServletConfig config) {

        try {
            log.info("WEB框架系统正在初始化...");

            delegate.init(config);


        } catch (final Throwable t) {
            this.initSuccess = false;

            final String message = "SafeDispatcherServlet: \\n\"\n" +
                    "                + \"自包装的Spring DispatcherServlet初始化异常.\\n\"\n" +
                    "                + \"异常信息将被抛出,这个servlet将初始化失败.";

            log.error(message);

            System.err.println(message);

            t.printStackTrace();

            ServletContext context = config.getServletContext();
            context.log(message, t);

        }
        log.info("WEB框架系统成功启动完成...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        if (initSuccess) {
            this.delegate.service(req, res);
        }else {
            throw new ApplicationContextException("没有初始化ServletContext!!!");
        }
    }
}
