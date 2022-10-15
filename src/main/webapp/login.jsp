<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<c:if test="${requestScope.errors.mispatch}">암호가 일치하지 않습니다.</c:if>
<form name="login" action="<c:url value="/login/login.do" />" method="post">
    이메일 : <br>
    <input type="text" name="email" value="${param.email}">
    <c:if test="${requestScope.errors.email}">
        이메일을 입력하세요.
    </c:if>
    <br>
    암호 : <br>
    <input type="password" name="password">
    <c:if test="${requestScope.errors.password}">
        암호를 입력하세요.
    </c:if>
    <br>
    <input type="submit" value="로그인">
</form>
</body>
</html>