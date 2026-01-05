package com.railway.servlet;

import com.railway.util.DBUtil;
import com.railway.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> userList = new ArrayList<>();

        try {
            Connection con = DBUtil.getConnection();
            String sql = "SELECT user_id, username, full_name, email FROM users";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                userList.add(u);
            }

            request.setAttribute("users", userList);
            RequestDispatcher rd = request.getRequestDispatcher("viewUsers.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading users");
        }
    }
}
