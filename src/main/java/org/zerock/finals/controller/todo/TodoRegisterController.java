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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.isNew()){ //기존에 JSESSIONID가 없는 새로운사용자
            System.out.println("JSESSIONID 쿠키가 새로 만들어진 사용자");
            response.sendRedirect("/login");
            return;
        }
        //JSISSIONID는 있지만 해당 세선컨텍스트에 로그인정보가 없는경우
        if(session.getAttribute("loginInfo")==null){
            System.out.println("로그인한 정보가 없는 사용자");
            response.sendRedirect("/login");
            return;
        }
        //로그인을 한 경우
        request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        TodoDTO todoDTO = TodoDTO.builder()
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATEFORMATTER))
                .id(id)
                .build();
        try{
            todoService.register(todoDTO);
            todoService.tnoReset();
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list?id="+id);
    }
}
