<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세페이지</h1>
	<input class="form-control" type="text" name="bno" value="${board.bno }" /><br/>
	<input class="form-control" type="text" name="title" value="${board.title }" /><br/>
	<textarea class="form-control" name="content">${board.content}</textarea><br/>
	<input class="form-control" type="text" name="writer" value="${board.writer}" /><br/>
	<input class="form-control" type="text" name="regdate" value="${board.regdate }" /><br/>
	<input class="form-control" type="text" name="updatedate" value="${board.updatedate }" /><br/>
	<a class="form-control" href="/board/list"><button>목록으로</button></a>
	<form action="/board/remove" method="post">
		<input type="hidden" name="bno" value="${board.bno }" />
		<input class="form-control" type="submit" value="삭제"/>
	</form>
	<form action="/board/boardmodify" method="post">
		<input type="hidden" name="bno" value="${board.bno }" />
		<input class="form-control" type="submit" value="수정하러가기"/>
	</form>
</body>
</html>