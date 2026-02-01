package com.study.transactional.interceptor;
/*
*
* Spring Interceptors sit between DispatcherServlet and Controllers, allowing pre-processing, post-processing, and cleanup logic around request handling.
*
*
*
* */


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token=request.getHeader("X-API-KEY");
        if (token == null || !token.equals("sec") ){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("✅ Handler executed for: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {

//        long startTime = (long) request.getAttribute("startTime");
//        long duration = System.currentTimeMillis() - startTime;

        System.out.println("⏱ Request completed in  ms");

        if (ex != null) {
            System.out.println("❌ Exception occurred: " + ex.getMessage());
        }
    }
}
