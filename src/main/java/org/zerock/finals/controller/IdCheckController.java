package org.zerock.finals.controller;

import org.zerock.finals.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "idCheckController", value = "/idCheck")
public class IdCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        boolean ck = true;
        try {
            ck = MemberService.INSTANCE.joinIdCheck(mid);
            request.setAttribute("ck",ck);
            request.getRequestDispatcher("/WEB-INF/idck.jsp").forward(request,response);
        }catch (Exception e){
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
