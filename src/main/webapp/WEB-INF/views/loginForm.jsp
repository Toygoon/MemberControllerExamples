<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${errors.notfound }">
		<font color="red">오류 : 등록되지 않은 이메일입니다.</font>
	</c:if>
	<c:if test="${errors.mismatch }">
		<font color="red">오류 : 암호가 일치하지 않습니다.</font>
	</c:if>
	<form action="login" method="post">
		이메일 : <input type="text" name="email" value="${email }" />
		<c:if test="${errors.email }">
			<font color="red">오류 : 이메일을 입력하세요.</font>
		</c:if>
		<p>
			암호 : <input type="password" name="password" />
			<c:if test="${errors.email }">
				<font color="red">오류 : 암호를 입력하세요.</font>
			</c:if>
		<p>
			<input type="submit" value="로그인" />
	</form>
</body>
</html>