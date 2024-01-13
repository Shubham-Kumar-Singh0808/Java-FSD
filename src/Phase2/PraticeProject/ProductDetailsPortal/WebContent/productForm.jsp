<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details Form</title>
</head>
<body>
    <form action="product" method="post">
        <label for="productId">Product ID:</label>
        <input type="text" id="productId" name="productId" required><br>

        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br>

        <label for="productPrice">Product Price:</label>
        <input type="number" id="productPrice" name="productPrice" required><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
