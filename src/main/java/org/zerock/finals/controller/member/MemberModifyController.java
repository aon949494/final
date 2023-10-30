package org.zerock.finals.controller.member;

import org.zerock.finals.dto.MemberDTO;
import org.zerock.finals.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "memberModifyController", value = "/member/modify")
public class MemberModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/member/modify.jsp").forward(request,response);
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
        try{
            MemberService.INSTANCE.modify(memberDTO);
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo",memberDTO);
            response.sendRedirect("/member/memberInfo");
        }catch (Exception e){

        }

    }
}
