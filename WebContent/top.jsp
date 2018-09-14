<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin-top: 0;
		margin-left: 0;
		margin-right: 0;
		margin-bottom: 0;
	}
	a{
	color:#ff0000; 
	text-decoration:none; 
	}
	a:HOVER {
	text-decoration: underline;
}
</style>
</head>
<body >
<div style="background-color:#003378;height: 120px;width:100%;color: #fff;margin-top: 0;background-image: url(bg.jpg) ">
<br><br><br>
<h2 style="margin-top: 0px;margin-right: 50px" align="right"><span>${User.nickname }(${User.username}),</span>
	欢迎使用邮件收发系统&nbsp;<a href="logout.jsp" target="_top" >退出</a></h2>
</div>
</body>
</html>