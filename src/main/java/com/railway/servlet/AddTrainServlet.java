package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class AddTrainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String trainNumber = request.getParameter("trainNumber");
        String trainName = request.getParameter("trainName");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO trains(train_number, train_name, source, destination) VALUES (?,?,?,?)");

            ps.setString(1, trainNumber);
            ps.setString(2, trainName);
            ps.setString(3, source);
            ps.setString(4, destination);

            ps.executeUpdate();

            // ✅ CHANGE IS HERE
            response.sendRedirect("adminHome.jsp?added=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
