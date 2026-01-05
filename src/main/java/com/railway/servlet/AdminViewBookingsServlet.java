package com.railway.servlet;

import com.railway.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class AdminViewBookingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Map<String, Object>> bookings = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {

            String sql = """
                SELECT b.booking_id, u.username, t.train_number, t.train_name,
                       ts.journey_date, ts.departure_time, b.seats
                FROM bookings b
                JOIN users u ON b.user_id = u.user_id
                JOIN train_schedule ts ON b.schedule_id = ts.schedule_id
                JOIN trains t ON ts.train_id = t.train_id
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("bookingId", rs.getInt("booking_id"));
                row.put("username", rs.getString("username"));
                row.put("trainNo", rs.getString("train_number"));
                row.put("trainName", rs.getString("train_name"));
                row.put("date", rs.getDate("journey_date"));
                row.put("time", rs.getTime("departure_time"));
                row.put("seats", rs.getInt("seats"));
                bookings.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("adminViewBookings.jsp").forward(request, response);
    }
}
