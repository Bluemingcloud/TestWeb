<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
		<h3>LOGIN</h3>
		<hr>
		<form action="user/login.user" method="post">
			<input type="text" name="id" placeholder="아이디" required="required" ><br>
			<input type="password" name="pw" placeholder="비밀번호" required="required" ><br>
			${msg }<br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='${user/join.user }'">
		
		</form>	
	</div>
</section>

<%@ include file="../include/footer.jsp" %>