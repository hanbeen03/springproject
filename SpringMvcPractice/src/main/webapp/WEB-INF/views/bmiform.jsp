<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>BMI ������ �غ��ϴ�.</h1>
	
	<form action="/bmi" method="post">
		Ű : <input type="number" name="height" placeholder="Ű(cm)" />cm<br/>
		ü�� : <input type="number" name="weight" placeholder="ü��(kg)" />kg<br/>
		<input type="submit" value="�����ϱ�">
	</form>
	
</body>
</html>