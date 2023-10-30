package org.zerock.finals.controller.memo;

import org.zerock.finals.service.MemoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "memoRemoveController", value = "/memo/remove")
public class MemoRemoveController extends HttpServlet {
    private MemoService memoService = MemoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));
        String id = request.getParameter("id");
        try {
            memoService.remove(tno);
            memoService.tnoReset();
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/memo/list?id="+id);
    }
}
