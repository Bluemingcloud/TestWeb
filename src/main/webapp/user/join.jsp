<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<section>
		<h3>JOIN</h3>
		<form action="user/join.user">
			<table>
				<tr>
					<td>아이디<td>
					<td><input type="text" name="id" placeholder="4글자 이상" required="required" pattern="[0-9a-zA-Z]{4,}"><td>
				</tr>
				<tr>
					<td>비밀번호<td>
					<td><input type="password" name="pw" placeholder="4글자 이상" required="required" pattern="[0-9a-zA-Z]{4,}"><td>
				</tr>
				<tr>
					<td>이름</td>				
					<td>
						<input type="text" 
						       name="name" 
						       placeholder="이름" 
						       required="required" 
						       pattern="^[a-zA-Z가-힣]+([ '-][a-zA-Z가-힣]+)*$"
						  />
					</td>								
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" placeholder="이메일"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="M" checked="checked">남자
						<input type="radio" name="gender" value="F">여자
					</td>
				</tr>
			</table>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>