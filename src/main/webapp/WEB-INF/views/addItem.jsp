<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add Item</title>
</head>
<body>
<h2>Le Cafe Add Item Page</h2>
  <form action="/addItem" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type = "text" id="name" name="name" required minlength="2" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input class="form-control" type="text" id="description" name="description" required minlength="2" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input class="form-control" type="number" id="quantity" name="quantity" required>
        </div>
        
        <div class="form-group">
            <label for="price">Price</label>
            <input class="form-control" type = "text" id="price" name="price" required>
        </div>            
        <button type="submit" class="btn btn-primary" value="submit">Add Item</button>
    </form>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>