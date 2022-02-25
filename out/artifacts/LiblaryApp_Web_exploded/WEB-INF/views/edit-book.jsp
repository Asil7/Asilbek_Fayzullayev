<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/10/2022
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</head>
<body>

<div class="container">

    <h4> Edit Author </h4>

    <form action="/books/editBook" method="post">

        <div class="form-group">
            <input hidden type="text" class="form-control" name="id" value="${book.id}">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail1">Book name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="name" value="${book.name}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">Description</label>
            <textarea class="form-control" id="exampleInputEmail2" name="description">${book.description}</textarea>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail3">price</label>
            <textarea class="form-control" id="exampleInputEmail3" name="price">${book.price}</textarea>
        </div>

        <input type="submit" class="btn btn-primary" value="Edit">


    </form>
</div>

</body>
</html>