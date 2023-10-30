package org.zerock.finals.controller.memo;

import org.zerock.finals.dto.MemoDTO;
import org.zerock.finals.service.MemoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "memoReadController", value = "/memo/read")
public class MemoReadController extends HttpServlet {
    private MemoService memoService = MemoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(request.getParameter("tno"));
            MemoDTO memoDTO = memoService.get(tno);
            request.setAttribute("dto",memoDTO);
            request.getRequestDispatcher("/WEB-INF/memo/read.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
