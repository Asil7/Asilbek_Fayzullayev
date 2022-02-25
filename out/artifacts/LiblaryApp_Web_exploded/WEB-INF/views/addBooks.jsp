<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add course</title>

    <title>Title</title>

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


    <form action="/books/postCourse" method="post">

        <div class="form-group">
            <label for="exampleInputEmail1"> Name</label>
            <input type="text" name="name" class="form-control" id="exampleInputEmail1"
                   placeholder="Enter book name">
            <label for="exampleInputEmail2">Description</label>
            <input type="text" name="description" class="form-control" id="exampleInputEmail2"
                   placeholder="Enter description">
            <label for="exampleInputEmail3"> Price</label>
            <input type="text" name="price" class="form-control" id="exampleInputEmail3"
                   placeholder="Enter price">

        </div>

        <br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

</div>

</body>
</html>