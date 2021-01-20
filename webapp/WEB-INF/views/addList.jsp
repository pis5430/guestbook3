<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guestbook</title>
</head>
<body>



	
	<form action="/guestbook3/guest/add" method="post"> <%--컨트롤러로 --%>
		
		<h2>addList 메인화면(등록 및 리스트 출력 가능)</h2>	<%--form 밖으로 나가면 글씨가 안보임..왜??? --%>
		
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" width="60" name="name"></td>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="4" ><textarea rows="5" cols="70" name="content"></textarea></td>
			</tr>	
			<tr>
				<td colspan="4"> <button type="submit">확인</button> </td>
			</tr>	
		</table>
			
		
	</form>
	
	<br><br>
		<c:forEach items="${requestScope.gList}" var="guestVo" >
			<table border = "1">
				<tr>
					<td>${guestVo.no}</td>
					<td>${guestVo.name}</td>
					<td>${guestVo.date}</td>
					<td><a href="/guestbook3/guest/deform?no=${guestVo.no}">[삭제]</a></td>
					<%--a태그에는 원래 value속성이 없다. 넣어서 시도해봣는데 안됨 --%>
					<%--href="경로?action=deform&no=삭제할 정보의 번호 불러오기" --%>
					<%--actin값으로 deform이 들어간 것은 확인이 되나 오류가남 = form에서 no값을 불러오는과정에서 실수 --%>
				</tr>
				<tr>
					<td colspan="4">
					${guestVo.content }
					</td>
				</tr>	
			</table>
			<br>
		</c:forEach>
	



</body>
</html>