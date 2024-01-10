package com.mphasis.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM products WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, productId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String productName = resultSet.getString("name");
                        double productPrice = resultSet.getDouble("price");

                        PrintWriter out = response.getWriter();
                        out.println("<html><body>");
                        out.println("<h2>Product Details</h2>");
                        out.println("<p>ID: " + productId + "</p>");
                        out.println("<p>Name: " + productName + "</p>");
                        out.println("<p>Price: $" + productPrice + "</p>");
                        out.println("</body></html>");
                    } else {
                        response.getWriter().println("<html><body><h2>Product not found</h2></body></html>");
                    }
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error retrieving product details", e);
        }
    }
}
