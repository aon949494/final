package org.zerock.finals.controller;

import org.zerock.finals.dto.MemberDTO;
import org.zerock.finals.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "joinController", value = "/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<MemberDTO> dtoList = MemberService.INSTANCE.listAll();
            request.setAttribute("dtoList",dtoList);
        }catch (Exception e){
            System.out.println("nono");
        }
        request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String maddr = addr1+" "+addr2;
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .mage(LocalDate.parse(request.getParameter("mage")))
                .maddr(maddr)
                .build();
        try {
            MemberService.INSTANCE.register(memberDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/login");
    }
}
