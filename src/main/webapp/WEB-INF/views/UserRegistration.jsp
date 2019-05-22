<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Le Cafe User Registration</title>
</head>
<body>
<h2>Please fill out the form to register!</h2>

    <form action="UserRegistration/Add" method=post>
<div class="form-group">
                <label for="userName">User Name</label>
                <input class="form-control" type = "text" id="userName" name="userName" required minlength="2" autocomplete="off">
            </div>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input class="form-control" type = "text" id="firstName" name="firstName" required minlength="2" autocomplete="off">
            </div>
            <div class="form-group">
                <label for="lastname">Last Name</label>
                <input class="form-control" id="lastName" name="lastName" required minlength="2" autocomplete="off">
            </div>
            <div class="form-group">
                <label for="email">E-Mail</label>
                <input class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                <input type="radio" id="gender" name="gender" value="male"> Male
                <input type="radio" id="gender" name="gender" value="female"> Female
                <input type="radio" id="gender" name="gender" value="other"> Other
            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <input type="number" id="age" name="age">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required minlength="8">
            </div>
            <button type="submit" class="btn btn-primary" value="submit">Register</button>
            <a href="/" class="btn btn-secondary">Home</a>
        </form>
</body>
</html>