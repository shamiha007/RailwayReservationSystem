package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class CancelBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        try {
            Connection con = DBUtil.getConnection();

            // 1️⃣ Get schedule_id and seats from booking
            PreparedStatement ps1 =
                con.prepareStatement(
                    "SELECT schedule_id, seats FROM bookings WHERE booking_id=?");
            ps1.setInt(1, bookingId);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int scheduleId = rs.getInt("schedule_id");
                int seats = rs.getInt("seats");

                // 2️⃣ Add seats back
                PreparedStatement ps2 =
                    con.prepareStatement(
                        "UPDATE train_schedule SET available_seats = available_seats + ? WHERE schedule_id=?");
                ps2.setInt(1, seats);
                ps2.setInt(2, scheduleId);
                ps2.executeUpdate();

                // 3️⃣ Delete booking
                PreparedStatement ps3 =
                    con.prepareStatement("DELETE FROM bookings WHERE booking_id=?");
                ps3.setInt(1, bookingId);
                ps3.executeUpdate();
            }

            response.sendRedirect("myBookings?cancelled=true");


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
