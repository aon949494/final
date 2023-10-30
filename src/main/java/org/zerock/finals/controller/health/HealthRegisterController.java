package org.zerock.finals.controller.health;

import org.zerock.finals.dto.HealthDTO;
import org.zerock.finals.service.HealthService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "healthRegisterController", value = "/health/register")
public class HealthRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/health/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HealthDTO healthDTO = HealthDTO.builder()
                .id(request.getParameter("id"))
                .height(Integer.parseInt(request.getParameter("height")))
                .weight(Integer.parseInt(request.getParameter("weight")))
                .move(request.getParameter("move"))
                .kal(Float.parseFloat(request.getParameter("kal")))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .build();
        try{
            HealthService.INSTANCE.register(healthDTO);
        }catch (Exception e){
            System.out.println("nono");
        }
        response.sendRedirect("/health/register");
    }
}
