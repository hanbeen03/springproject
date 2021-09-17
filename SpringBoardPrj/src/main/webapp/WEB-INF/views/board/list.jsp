<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.searchForm {
		text-align: right;
	}
</style>
</head>
<body>
	<!-- ${getBno } -->
	<h1>글 목록 조회</h1>
	<table border=1 class="table table-striped">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성날짜</th>
				<th>수정날짜</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.bno }</td>
				<td><a href="/board/get?bno=${list.bno}">${list.title }</a></td>
				<td>${list.writer }</td>
				<td>${list.regdate }</td>
				<td>${list.updatedate }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 
	<c:if test="${result eq 'success' }">
		<script>alert('글이 삭제되었습니다.');</script>
	</c:if>
	-->
	
	<form action="/board/register">
		<input type="submit" value="글쓰기">
	</form>
	
	<form class="searchForm" action="/board/list" >
		<input type="text" name="keyword" value="${keyword }"/>
		<input type="submit" value="검색"/>
	</form>
	
	
	<script>
		var result = "${result}";
		var bno = "${bno}";
		var getBno = "${getBno}";
		console.log(result);
		
		window.onload = function() {
			if(result === 'success') {
				alert(bno + '번 글이 삭제되었습니다.');
			}
			if(getBno != null) {
				alert(getBno + '번 글이 등록되었습니다.');
			}
		}
	</script>
</body>
</html>