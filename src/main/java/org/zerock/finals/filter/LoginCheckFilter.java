package org.zerock.finals.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*","/memo/*","/member/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException,IOException {
        //ServletRequest 하위에 HttpServletRequest 가 있음. 즉 ServletRequest 가 상위개념.
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("loginInfo")==null){
            res.sendRedirect("/login");
            return;
        }
        chain.doFilter(request,response);


    }
}
