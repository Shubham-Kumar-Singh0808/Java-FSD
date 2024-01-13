<%@ page import="com.ecommerce.Product" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details</h2>
    
    <% 
        HttpSession productSession = request.getSession();
        Product product = (Product) productSession.getAttribute("product");
    %>
    
    <p><strong>Product ID:</strong> <%= product.getProductId() %></p>
    <p><strong>Product Name:</strong> <%= product.getProductName() %></p>
    <p><strong>Product Price:</strong> <%= product.getProductPrice() %></p>
    
</body>
</html>
