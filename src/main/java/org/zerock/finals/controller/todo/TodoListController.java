package org.zerock.finals.controller.todo;

import org.zerock.finals.dto.TodoDTO;
import org.zerock.finals.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            List<TodoDTO> dtoList = todoService.listAll(id);
            request.setAttribute("dtoList", dtoList);
            request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
