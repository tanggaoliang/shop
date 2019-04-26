/**
 * @author: tang gao liang
 * @time:2019/4/17 22:17:56
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.interceptor;

import com.tang.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] equalUri = {"/register", "/", "/index","/check","/listCategory"};
        String[] containUri = {"bootstrap", "favicon", "css", "js","login"};
        String uri = request.getRequestURI();
        //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
        for (String item : equalUri) {
            if (item.equals(uri)) {
                return true;
            }
        }

        for (String item : containUri) {
            if (uri.contains(item)) {
                return true;
            }
        }
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (user != null) {
            return true;
        }
        //不符合条件的给出提示信息，并转发到登录页面
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('请您先登录'); window.location='/' </script>");
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
