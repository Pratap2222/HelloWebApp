package com.example.helloweb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.nio.file.*;

public class GreetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        Path path = Paths.get("/tmp/username.txt");
        Files.write(path, name.getBytes());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hi " + name + "!</h1>");
        out.println("</body></html>");
    }
}
