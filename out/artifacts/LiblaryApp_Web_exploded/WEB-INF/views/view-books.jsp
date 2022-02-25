<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/9/2022
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
        .btn-add {
            margin-top: 10px;
            text-align: center;
        }
    </style>

</head>
<body>

<ul>
    <h1>Books</h1>
    <%--    <c:forEach var="author" items="${authorList}">--%>
    <%--        <li>${author.fullName}</li>--%>

    <%--    </c:forEach>--%>
</ul>

<hr>

<form action="/books/searched" method="post">
    <label for="exampleInputEmail1">Search </label>
    <input type="text" name="s" class="form-control" id="exampleInputEmail1" placeholder="Search book ">
    <br>
    <button type="submit" class="btn btn-primary">Search</button>
    <a href="/books" class="btn btn-danger">All books</a>
</form>


<div class="container">


    <div class="row">
        <div class="btn-add">
            <a href="/books/addBooks" class="btn btn-danger">Add new books</a>
        </div>
    </div>
    <div class="container">

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="books" items="${BookList}">
                <tr>
                    <td>
                        <a href="/books/information/${books.id}" style=" text-decoration: none;black:#000;">
                            <h5 class="card-title">${books.name}</h5>
                        </a>
                    </td>
                    <td>
                        <h5 class="card-title">${books.description}</h5>
                    </td>

                    <td>
                        <h5 class="card-title">${books.price}</h5>
                    </td>
                    <td>
                        <a href="/books/editBook?id=${books.id}" class="btn btn-primary">Edit</a>
                        <a href="/books/delete/${books.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>