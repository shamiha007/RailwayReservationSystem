package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class AddScheduleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int trainId = Integer.parseInt(request.getParameter("trainId"));
        String journeyDate = request.getParameter("journeyDate");
        String departureTime = request.getParameter("departureTime");
        int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO train_schedule(train_id, journey_date, departure_time, available_seats) VALUES (?,?,?,?)");

            ps.setInt(1, trainId);
            ps.setString(2, journeyDate);
            ps.setString(3, departureTime);
            ps.setInt(4, availableSeats);

            ps.executeUpdate();

            response.sendRedirect("adminHome.jsp?scheduleAdded=true");


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
