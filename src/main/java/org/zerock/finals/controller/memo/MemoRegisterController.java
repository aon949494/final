package org.zerock.finals.controller.memo;

import org.zerock.finals.dto.MemoDTO;
import org.zerock.finals.service.MemoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "memoRegisterController", value = "/memo/register")
public class MemoRegisterController extends HttpServlet {
    MemoService memoService = MemoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/memo/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MemoDTO memoDTO = MemoDTO.builder()
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .id(id)
                .build();
        try {
            memoService.register(memoDTO);
            memoService.tnoReset();
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/memo/list?id="+id);
    }
}
