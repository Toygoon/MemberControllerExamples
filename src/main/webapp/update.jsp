<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정/삭제</title>
</head>
<body>
<script type="text/javascript">
	function deleteClicked() {
		result = confirm("정말 삭제하시겠습니까?")
		
		if (result) {
			document.form1.action = "/ex/member/delete.do"
			document.form1.submit()
		} else {
			return
		}
	}
</script>
<div align="center">
    <h2>회원 정보 수정/삭제</h2>
    <br>
    <form name="form1" action="<c:url value="/member/update.do" />">
        <input type="hidden" name="id" value="${requestScope.member.id}">
        <table border="1">
            <tr>
                <th>이름</th>
                <td><input type="id" name="name" value="${requestScope.member.name}"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="password" value="${requestScope.member.password}"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="email" name="email" value="${requestScope.member.email}"></td>
            </tr>
            <tr>
                <th>가입일</th>
                <td><input type="regdate" name="regdate" value="${requestScope.member.regdate}"></td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="수정">
                    <input type="reset" value="취소">
                    <input type="button" value="삭제" onClick="deleteClicked()">
                </td>
        </table>
    </form>
</div>
</body>
</html>