package org.zerock.finals.controller;

import org.zerock.finals.dto.MemberDTO;
import org.zerock.finals.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login get....");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");
        String auto = request.getParameter("auto");
        boolean rememberMe = auto!=null && auto.equals("on");
        if(rememberMe){
            String UUid = UUID.randomUUID().toString();//랜덤한 문자열로생성.128비트
        }
        try {
            MemberDTO memberDTO = memberService.login(mid,mpw);
            if(rememberMe){
                String UUid = UUID.randomUUID().toString();
                MemberService.INSTANCE.updateUUID(mid,UUid);
                memberDTO.setUuid(UUid);

                Cookie rememberCookie = new Cookie("remember-me",UUid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");
                response.addCookie(rememberCookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo",memberDTO);
            response.sendRedirect("/todo/home");
        }catch (Exception e){
            response.setContentType("text/html;charset = utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html><script>");
            out.println("alert('아이디나 비밀번호가 일치하지않습니다!')");
            out.println("location.href='/login?result=error'");
            out.println("</script></html>");
            System.out.println("x");
        }
        /*String str = mid+mpw;
        HttpSession session = request.getSession();
        session.setAttribute("loginInfo",str);

        //String name = (String)session.getAttribute("str");
        response.sendRedirect("/todo/list");*/
    }
}
