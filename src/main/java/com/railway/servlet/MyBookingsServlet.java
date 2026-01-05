package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.util.DBUtil;

public class MyBookingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        try {
            Connection con = DBUtil.getConnection();

            String sql =
                "SELECT b.booking_id, t.train_number, t.train_name, " +
                "s.journey_date, s.departure_time, b.seats " +
                "FROM bookings b " +
                "JOIN train_schedule s ON b.schedule_id = s.schedule_id " +
                "JOIN trains t ON s.train_id = t.train_id " +
                "WHERE b.user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            request.setAttribute("bookings", rs);

            request.getRequestDispatcher("myBookings.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
