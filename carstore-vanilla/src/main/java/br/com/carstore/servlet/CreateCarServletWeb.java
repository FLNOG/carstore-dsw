package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create-car-v")
public class CreateCarServletWeb extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String carName = httpServletRequest.getParameter("car-name");

        System.out.println(carName);

        String color = httpServletRequest.getParameter("color");

        System.out.println(color);

        if (null == carName || carName.equals("")) {
            httpServletRequest.setAttribute("error", "Campo Inválido");
        } else {
            httpServletRequest.setAttribute("success", "Cadastro realizado com sucesso");
        }

        httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);

    }

}
