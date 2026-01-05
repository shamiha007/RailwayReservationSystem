package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");

        try {
            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO users(username, password, full_name, email) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setString(4, email);

            ps.executeUpdate();

            // ✅ redirect to login with flag
            response.sendRedirect("login.jsp?registered=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
