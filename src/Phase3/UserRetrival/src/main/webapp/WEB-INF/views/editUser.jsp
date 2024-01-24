<!-- src/main/webapp/WEB-INF/views/editUser.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <label for="id">User ID:</label>
        <input type="text" id="id" name="id" value="${user.id}" readonly><br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}"><br>
        <!-- Add other fields as needed -->
        <input type="submit" value="Update">
    </form>
</body>
</html>
