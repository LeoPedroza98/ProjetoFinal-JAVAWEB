package com.tbp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInteceptor implements HandlerInterceptor {

    @Autowired
    UserSession userSession;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
       // System.out.println(url);
        Person person = userSession.getLoggerUser();
        if (person != null){
            return true;
        }else if (url.contains("/person/create") || url.contains("login") || url.contains("error") || url.contains("specialty/create") || url.contains("specialty/all")){
            return true;
        }
        String loginPage = httpServletRequest.getContextPath()+ "/login/doLogin";
        httpServletResponse.sendRedirect(loginPage);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
