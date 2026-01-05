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

public class BookTicketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        int seats = Integer.parseInt(request.getParameter("seats"));

        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");

        try {
            Connection con = DBUtil.getConnection();

            // 1️⃣ Check available seats
            PreparedStatement ps1 =
                con.prepareStatement("SELECT available_seats FROM train_schedule WHERE schedule_id=?");
            ps1.setInt(1, scheduleId);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int available = rs.getInt("available_seats");

                if (available < seats) {
                    response.getWriter().println("Not enough seats available");
                    return;
                }

                // 2️⃣ Insert booking
                PreparedStatement ps2 =
                    con.prepareStatement("INSERT INTO bookings(user_id, schedule_id, seats) VALUES (?,?,?)");
                ps2.setInt(1, userId);
                ps2.setInt(2, scheduleId);
                ps2.setInt(3, seats);
                ps2.executeUpdate();

                // 3️⃣ Reduce seats
                PreparedStatement ps3 =
                    con.prepareStatement(
                        "UPDATE train_schedule SET available_seats = available_seats - ? WHERE schedule_id=?");
                ps3.setInt(1, seats);
                ps3.setInt(2, scheduleId);
                ps3.executeUpdate();

                response.sendRedirect("myBookings?booked=true");


            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
