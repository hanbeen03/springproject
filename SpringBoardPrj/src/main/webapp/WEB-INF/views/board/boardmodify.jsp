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
	<h1>글 수정 창</h1>
	<form action="/board/modify" method="post">
		<input class="form-control" type="text" name="bno" value="${board.bno }" readonly/><br>
		<input class="form-control" type="text" name="title" value="${board.title }"/><br>
		<textarea class="form-control" name="content" placeholder="내용" rows="10" cols="30">${board.content }</textarea><br>
		<input class="form-control" type="text" name="writer" value="${board.writer }" readonly/><br>
		<input class="form-control" type="submit" value="수정하기" />&nbsp;
		<input class="form-control" type="reset" value="초기화" />&nbsp;
	</form>
</body>
</html>