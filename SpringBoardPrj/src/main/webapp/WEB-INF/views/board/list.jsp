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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	
	 
	<div class="modal" id="myModal" tabindex="-1">
 	   <div class="modal-dialog">
   		 <div class="modal-content">
     		 <div class="modal-header">
        		<h5 class="modal-title">${result}</h5>
        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
     	 </div>
      	<div class="modal-body">
     	   <p>${getBno}번 글이 등록되었습니다.</p>
      	</div>
      	<div class="modal-footer">
        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
     	 </div>
   	 </div>
  	</div>
	</div>
	
	
	<!-- 
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
-->
	
	<script>
		var result = "${result}";
		var bno = "${bno}";
		var getBno = "${getBno}";
		//var myModal = document.getElementById('myModal');
		//var myInput = document.getElementById('myInput');
		var myModal = new bootstrap.Modal(document.getElementById('myModal'), focus);
		console.log(result);
		
		window.onload = function() {
			if(result === 'success') {
				alert(bno + '번 글이 삭제되었습니다.');
			} else if(result === 'register') {
				//alert(getBno + '번 글 작성 완료');
				myModal.show();
			}
			//if(getBno != "") {
			//	alert(getBno + '번 글이 등록되었습니다.');
			//}
		}
		
	</script>
</body>
</html>