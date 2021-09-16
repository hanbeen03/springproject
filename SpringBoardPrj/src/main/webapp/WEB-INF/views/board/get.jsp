<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세페이지</h1>
	<input type="text" name="bno" value="${board.bno }" /><br/>
	<input type="text" name="title" value="${board.title }" /><br/>
	<textarea name="content">${board.content}</textarea><br/>
	<input type="text" name="writer" value="${board.writer}" /><br/>
	<input type="text" name="regdate" value="${board.regdate }" /><br/>
	<input type="text" name="updatedate" value="${board.updatedate }"/><br/>
	<a href="/board/list">목록으로</a>
</body>
</html>