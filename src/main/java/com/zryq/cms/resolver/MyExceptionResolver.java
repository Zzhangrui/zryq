package com.zryq.cms.resolver;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mark
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    private static final String X_REQUESTED_WITH = "X-Requested-With";
    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionResolver.class);
    private static final String DEFAULT_EXCEPTION_MSG = "服务器端异常！";
    private static final String UNAUTHORIZED_EXCEPTION_MSG = "对不起，您没有权限操作！";

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        String requestType = request.getHeader(X_REQUESTED_WITH);
        String errorMsg;

        // ajax 异常处理
        if (XML_HTTP_REQUEST.equals(requestType)) {
            String contentType = "application/json;charset=UTF-8";
            response.setContentType(contentType);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (ex instanceof UnauthorizedException) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                errorMsg = UNAUTHORIZED_EXCEPTION_MSG;
            } else {
                errorMsg = DEFAULT_EXCEPTION_MSG;
            }
            LOGGER.warn("code {}, msg {} ,ex {}", response.getStatus(), errorMsg, ex);
            try {
                PrintWriter writer = response.getWriter();
                writer.write(errorMsg);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
            return null;
        } else {
            if (ex instanceof UnauthorizedException) {
                ModelAndView mv = new ModelAndView("redirect:/401");
                return mv;
            }

            if (ex instanceof InvalidSessionException) {
                SecurityUtils.getSubject().logout();
                ModelAndView mv = new ModelAndView("redirect:/logout");
                return mv;
            }

            LOGGER.error(ex.toString());
            ex.printStackTrace();
            ModelAndView mv = new ModelAndView("redirect:/500");
            return mv;
        }
    }
}
