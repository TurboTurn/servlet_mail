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
	 	font-family: "΢���ź�";
		font-size: 16px;	
	}
</style>
</head>
<%
  	
  	String gender=((User)session.getAttribute("User")).getSex();
  	String maleChecked="",femaleChecked="";
  	if(gender.equals("��")){
  		maleChecked="checked";
  	}else if(gender.equals("Ů"))
  		femaleChecked="checked";
  	
  	
   %>
<body>
<div>
	<form action="UpdateUser" method="post">
	<p>����<input type="password" name="password" value="" /></p>
	<p>�ǳ�<input type="text" name="nickname" value="${User.nickname }" /></p>
	<p>�Ա�<input type="radio" name="sex" value="��" <%=maleChecked %>/>��
			<input type="radio" name="sex" value="Ů" <%=femaleChecked %>/>Ů</p>
	<p>����<input type="text" name="birth" value="${User.birth }" /></p>
	<input type="submit" value="ȷ���޸�">
	</form>
</div>
</body>
</html>