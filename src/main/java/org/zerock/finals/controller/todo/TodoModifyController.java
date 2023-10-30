package org.zerock.finals.controller.todo;

import org.zerock.finals.dto.TodoDTO;
import org.zerock.finals.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoModifyController", value = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(request.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);
            request.setAttribute("dto", todoDTO);
            request.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String finishedStr = request.getParameter("finished");
        String id = request.getParameter("id");
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(Long.parseLong(request.getParameter("tno")))
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"), DATEFORMATTER))
                .finished(finishedStr != null && finishedStr.equals("on"))
                .id(id)
                .build();
        try{
            todoService.modify(todoDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list?id="+id);
    }
}
