package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ecommerce.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);

        Configuration config = new Configuration().configure("hibernate/hibernate.cfg.xml");
        try (SessionFactory factory = config.buildSessionFactory();
             Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }

        response.sendRedirect("success.jsp");
    }
}
