package org.zerock.finals.controller.todo;

import org.zerock.finals.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRemoveController", value = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));
        String id = request.getParameter("id");
        try{
            todoService.remove(tno);
            todoService.tnoReset();
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list?id="+id);
    }
}
