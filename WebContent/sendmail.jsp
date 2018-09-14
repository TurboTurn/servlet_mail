<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color: #f5f7fa;
	}
	textarea{
		width: 600px;
		height:200px
	}
</style>
<style type="text/css">
	a{
	text-decoration: none;
	}
	p,span{
	font-family: "微软雅黑";
	font-size: 16px;
	}
</style>
</head>
<%
	String receiver="";
	String rec=request.getParameter("receiver");
	if(rec!=null){
		receiver=rec;
	}
%>
<body>
<form action="SendMail" method="post">
<div >
<p>发件人<input value="${User.nickname }(${User.username })" style="width: 400px" readonly="readonly"
			name="sender"/></p>
<p>收件人<input style="width: 400px" name="receiver" value="<%=receiver %>"/></p>
<p>主&nbsp;&nbsp;题<input style="width: 400px" name="subject"/></p>
<span>正文</span><br><textarea name="text"  cols="30" rows="10"></textarea><br>
<input type="file" name="fujian" />
<input type="submit" style="width:55px;height:30px;background:green;color:white;font-size: 16px" value="发送">
</div>
</form>
</body>
</html>