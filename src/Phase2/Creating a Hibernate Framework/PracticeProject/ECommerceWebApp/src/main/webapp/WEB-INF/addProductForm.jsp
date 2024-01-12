<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <form action="addProduct" method="post">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br>

        <label for="productPrice">Product Price:</label>
        <input type="text" id="productPrice" name="productPrice" required><br>

        <input type="submit" value="Add Product">
    </form>
</body>
</html>
