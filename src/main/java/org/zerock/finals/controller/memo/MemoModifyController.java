package org.zerock.finals.controller.memo;

import org.zerock.finals.dto.MemoDTO;
import org.zerock.finals.service.MemoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "memoModifyController", value = "/memo/modify")
public class MemoModifyController extends HttpServlet {
    private MemoService memoService = MemoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(request.getParameter("tno"));
            MemoDTO memoDTO = memoService.get(tno);
            request.setAttribute("dto",memoDTO);
            request.getRequestDispatcher("/WEB-INF/memo/modify.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MemoDTO memoDTO = MemoDTO.builder()
                .tno(Long.parseLong(request.getParameter("tno")))
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .id(id)
                .build();
        try {
            memoService.modify(memoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/memo/list?id="+id);
    }
}
