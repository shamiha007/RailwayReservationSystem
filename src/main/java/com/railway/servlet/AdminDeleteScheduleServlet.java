package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

@WebServlet("/adminDeleteSchedule")
public class AdminDeleteScheduleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));

        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = DBUtil.getConnection();

            // 1️⃣ delete bookings first
            ps1 = con.prepareStatement(
                "DELETE FROM bookings WHERE schedule_id = ?");
            ps1.setInt(1, scheduleId);
            ps1.executeUpdate();

            // 2️⃣ delete schedule
            ps2 = con.prepareStatement(
                "DELETE FROM train_schedule WHERE schedule_id = ?");
            ps2.setInt(1, scheduleId);
            ps2.executeUpdate();

            response.sendRedirect("adminViewTrains.jsp?deleted=true");


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting schedule");
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
            } catch (Exception e) {}
        }
    }
}
