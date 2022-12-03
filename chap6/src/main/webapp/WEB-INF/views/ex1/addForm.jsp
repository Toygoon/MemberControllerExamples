<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	<div align="center">
		<h2>새로운 멤버 추가</h2>
		<br>
		<form action="add" method="post">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><input type="text" name="regdate"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력"></td>
				</tr>
			</table>
			<a href="/chap6/ex1/list">회원 리스트</a>
		</form>
	</div>
</body>
</html>