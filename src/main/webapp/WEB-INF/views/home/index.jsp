
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách học sinh</h1>
    <p><a href="/home/create">Add</a></p>
    <div>
        <form method="get" action="/home/index">
            <input type="hidden" name="action" value="index">
            <b>Find: </b>
            <input type="text" name="key" value="${key}">
            <button type="submit">Search</button>
        </form>
    </div>
    <table border="1">
        <tr>
            <th>Student_Id</th>
            <th>Student_Name</th>
            <th>Sex</th>
            <th>PhoneNumber</th>
            <th>Img</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.studentId}</td>
                <td>${s.studentName}</td>
                <td>${s.sex ? "Name":"Nữ"}</td>
                <td>${s.phoneNumber}</td>
                <td>
                    <img src="${s.imageUrl}" width="80">
                </td>
                <td><fmt:formatDate value="${s.birthday}" pattern="dd-MM-yyyy"/> </td>
                <td>${s.address}</td>
                <td>
                    <a href="/home/edit/${s.studentId}">Edit</a>
                    <a href="/home/delete/${s.studentId}" onclick="return confirm('Bạn có muốn xóa không')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
