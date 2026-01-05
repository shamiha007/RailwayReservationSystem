package com.railway.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.util.DBUtil;

public class ViewScheduleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int trainId = Integer.parseInt(request.getParameter("trainId"));

        List<Map<String, String>> schedules = new ArrayList<>();

        try {
            Connection con = DBUtil.getConnection();

            String sql =
                "SELECT ts.schedule_id, ts.journey_date, ts.departure_time, ts.available_seats, " +
                "t.train_number, t.train_name " +
                "FROM train_schedule ts " +
                "JOIN trains t ON ts.train_id = t.train_id " +
                "WHERE ts.train_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, trainId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, String> row = new HashMap<>();
                row.put("schedule_id", rs.getString("schedule_id"));
                row.put("train_number", rs.getString("train_number"));
                row.put("train_name", rs.getString("train_name"));
                row.put("journey_date", rs.getString("journey_date"));
                row.put("departure_time", rs.getString("departure_time"));
                row.put("available_seats", rs.getString("available_seats"));
                schedules.add(row);
            }

            request.setAttribute("schedules", schedules);
            RequestDispatcher rd = request.getRequestDispatcher("viewSchedule.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }
}
