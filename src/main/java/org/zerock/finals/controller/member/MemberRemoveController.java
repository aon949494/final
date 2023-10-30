package org.zerock.finals.controller.member;

import org.zerock.finals.service.MemberService;
import org.zerock.finals.service.MemoService;
import org.zerock.finals.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberRemoveController", value = "/member/remove")
public class MemberRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        request.setAttribute("mid",mid);
        request.getRequestDispatcher("/WEB-INF/member/remove.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        try{
            MemberService.INSTANCE.removeMem(mid);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><script>");
            out.println("opener.location.replace('/login')");
            out.println("window.close()");
            out.println("</script></html>");
        }catch (Exception e){
            System.out.println("memo");
        }




    }
}
