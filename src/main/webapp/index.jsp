<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인 예제</title>
</head>
<body>
<h2>${sessionScope.member.name} 님 안녕하세요.</h2>
<a href="<c:url value="/login/logout.do" />">[로그아웃]</a><br>
<a href="<c:url value="/login/changePwd.do" />">[암호변경]</a>
</body>
</html>
