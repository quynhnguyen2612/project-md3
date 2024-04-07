<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/home.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg  nav-bg">
                <a class="navbar-brand color-white" href="#">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/staffs?action=create">Create Staff <span class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                    <form  class="form-inline my-2 my-lg-0">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><a href="http://localhost:8080/staffs?action=searchName">Search</a></button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <table class="table">
                <thead>
                <tr class="nav-bg color-white">
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Department</th>
                    <th scope="col" colspan="2" style="padding-left: 5%">Action</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${staffs}" var="staff">
                    <tr>
                        <td>${staff.name}</td>
                        <td>${staff.email}</td>
                        <td>${staff.address}</td>
                        <td>${staff.phone}</td>
                        <td>${staff.salary}</td>
                        <td>${staff.department.name}</td>
                        <td><a href="http://localhost:8080/staffs?action=edit" class="btn btn-outline-warning">edit</a></td>
                        <td><a href="http://localhost:8080/staffs?action=delete&id=${staff.id}" class="btn btn-outline-danger" >delete</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>