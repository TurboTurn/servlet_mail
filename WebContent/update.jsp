<%@ page language="java" contentType="text/html; charset=gb2312" 
    pageEncoding="gb2312"%>
<%@ page import="java.util.* , model.vo.*" %>
<jsp:useBean id="dao" scope="page" class="model.dao.MessageDao"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color: #f5f7fa;
	}
	p{
	 	font-family: "微软雅黑";
		font-size: 16px;	
	}
</style>
</head>
<%
  	
  	String gender=((User)session.getAttribute("User")).getSex();
  	String maleChecked="",femaleChecked="";
  	if(gender.equals("男")){
  		maleChecked="checked";
  	}else if(gender.equals("女"))
  		femaleChecked="checked";
  	
  	
   %>
<body>
<div>
	<form action="UpdateUser" method="post">
	<p>密码<input type="password" name="password" value="" /></p>
	<p>昵称<input type="text" name="nickname" value="${User.nickname }" /></p>
	<p>性别<input type="radio" name="sex" value="男" <%=maleChecked %>/>男
			<input type="radio" name="sex" value="女" <%=femaleChecked %>/>女</p>
	<p>生日<input type="text" name="birth" value="${User.birth }" /></p>
	<input type="submit" value="确认修改">
	</form>
</div>
</body>
</html>