package com.example.lession17springbootinterceptator.authInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author admin
 * @classnam AuthInterceptor
 * @time 18:30
 * @date 2024/12/10
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Step 1: 检查当前请求的 URI 是否是首页 ("/")。
        if (request.getRequestURI().equals("/")){
            // 如果是首页，则直接放行，无需验证登录状态。
            return true;
        }
        // Step 2: 获取当前会话对象。
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        // 从会话中获取用户名，判断用户是否已登录。
        // Step 3: 检查会话中是否存在用户名。
        if (username!=null){
            return true;
        }
        // 用户未登录，重定向到登录页面。
        else {
            response.sendRedirect("/user/login");
            return false;
        }
    }
}
