package org.example.login_in_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.login_in_jsp.dao.loginDAO;

import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        loginDAO dao = new loginDAO();
        dao.check(uname, pass);

        if(dao.check(uname,pass)){
            HttpSession session = req.getSession();
            session.setAttribute("username", uname);
            res.sendRedirect("welcome.jsp");
        }
        else{
            res.sendRedirect("index.jsp");
        }
    }

    public void destroy() {

    }
}
