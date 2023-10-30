package org.zerock.finals.controller.memo;

import org.zerock.finals.dto.MemoDTO;
import org.zerock.finals.service.MemoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "memoListController", value = "/memo/list")
public class MemoListController extends HttpServlet {
    private MemoService memoService = MemoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            System.out.println(id);
            List<MemoDTO> dtoList = memoService.listAll(id);
            request.setAttribute("dtoList", dtoList);
            request.getRequestDispatcher("/WEB-INF/memo/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
