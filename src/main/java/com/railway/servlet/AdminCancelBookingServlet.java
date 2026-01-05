package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class AdminCancelBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookingId = request.getParameter("bookingId");

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM bookings WHERE booking_id = ?"
            );
            ps.setInt(1, Integer.parseInt(bookingId));
            ps.executeUpdate();

            // Redirect with success flag
            response.sendRedirect("viewAllBookings?cancelled=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewAllBookings?cancelled=false");
        }
    }
}
