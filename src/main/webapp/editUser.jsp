<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>
<form action="${request.getContextPath()}/user" method="post">
    <input type="hidden" name="id" value="${editedUser.id}"> <!-- Include user ID as a hidden field -->

    <label>First Name: <input type="text" name="firstName" value="${editedUser.firstName}"></label><br>
    <label>Last Name: <input type="text" name="lastName" value="${editedUser.lastName}"></label><br>
    <label>Age: <input type="number" name="age" value="${editedUser.age}"></label><br>

    <input type="submit" value="Save Changes">
</form>
</body>
</html>
