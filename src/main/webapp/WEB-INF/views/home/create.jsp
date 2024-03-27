
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm danh sách học sinh</h1>
<f:form method="post" enctype="multipart/form-data" modelAttribute="students">
    <table border="1">
        <tr>
            <th>Student_Id</th>
            <td><f:input path="studentId"/></td>
        </tr>
        <tr>
            <th>Student_Name</th>
            <td><f:input path="studentName"/></td>
        </tr>
        <tr>
            <th>Sex</th>
            <td><f:input path="sex"/></td>
        </tr>
        <tr>
            <th>PhoneNumber</th>
            <td><f:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <th>Img</th>
            <td><f:input path="imageUrl" type ="file" /></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><f:input path="birthday" type="date" /></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><f:input path="address"/></td>
        </tr>
    </table>
    <button>Save</button>
</f:form>


</body>
</html>
