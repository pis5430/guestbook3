<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook3/guest/delete" method="post">
		
		비밀번호 : <input type="text" name="password">
		<button type="submit">확인</button>
		<br>
		<a href="/gbc">메인으로 돌아가기</a>
		<%-- hidden--%>
		<input type="text" name="no" value="${param.no}">

		
		<c:if test="${!empty param.password}">
			<p>비밀번호가 틀립니다. 다시입력해주세요</p>
		</c:if>
	
	</form>
	


</body>
</html>