<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정/삭제</title>
</head>
<script type="text/javascript">
	function onClicked() {
		check = confirm("정말 삭제하시겠습니까?");
		
		if (check) {
			document.form1.action = "/chap6/ex1/delete/${member.id}";
			document.form1.submit();
		} else {
			return;
		}
	}
</script>
<body>
	<div align="center">
		<h2>회원정보 수정/삭제</h2>
		<br>
		<form name="form1" action="/chap6/ex1/update" method="post">
			<input type="hidden" name="id" value="${member.id }" />
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"
						value="${member.password }"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${member.email }"></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><input type="text" name="regdate"
						value="${member.regdate }"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="입력">
						<input type="reset" value="취소">
						<input type="button" value="삭제" onClick="onClicked()">
					</td>
				</tr>
			</table>
			<br> <br> <a href="/chap6/ex1/list">회원 리스트</a>
		</form>
	</div>
</body>
</html>