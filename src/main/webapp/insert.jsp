<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 추가</title>
</head>
<body>
<div align="center">
    <h2>회원 등록</h2>
    <hr>
    <form method="post" action="<c:url value="/member/insert.do"/>">
        <table border="1">
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <th>가입일</th>
                <td><input type="text" name="regdate" value="${requestScope.date}" required></td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" value="등록">
                    <input type="reset" value="취소"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
