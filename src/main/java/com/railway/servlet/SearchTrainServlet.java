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

public class SearchTrainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        List<Map<String, String>> trains = new ArrayList<>();

        try {
            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM trains WHERE source=? AND destination=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, String> train = new HashMap<>();
                train.put("train_id", rs.getString("train_id"));
                train.put("train_number", rs.getString("train_number"));
                train.put("train_name", rs.getString("train_name"));
                train.put("source", rs.getString("source"));
                train.put("destination", rs.getString("destination"));
                trains.add(train);
            }

            request.setAttribute("trains", trains);
            RequestDispatcher rd = request.getRequestDispatcher("availableTrains.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
