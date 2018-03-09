package com.pandawork.home.web.intercepter;

import com.pandawork.core.common.util.Assert;
import com.pandawork.home.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Taoyongpan on 2017/9/19.
 */
public class HanderInterceptor1 implements HandlerInterceptor {
    @Autowired
    UserService userService;


    private String[] allowUrls;//还没发现可以直接配置不拦截的资源，所以在代码里面来排除
    private String[] allowUrls1;//还没发现可以直接配置不拦截的资源，所以在代码里面来排除

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
//        System.out.println(requestUrl);

        if (null != allowUrls && allowUrls.length >= 1) {
            for (String url1 : allowUrls) {
                if (requestUrl.contains(url1)) {
                    return true;
                }
            }
        }
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String username1 = (String) session.getAttribute("username1");
        //线上代码
//        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/Home_id/tologin";

        //本地使用
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/tologin";

//        int power = (int) session.getAttribute("power");
        if (Assert.isNull(userService.queryByUname(username))&&Assert.isNull(userService.queryByUname(username1))) {
           response.sendRedirect(url);
           return false;
        }
        return true;
    }
}
