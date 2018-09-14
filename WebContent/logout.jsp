<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
  <script>
	 var t=3;
	 setInterval("f()",1000);
	  function f()
	  {
	  	   if(t==0)
			window.location.href="login.jsp";
		   t--;
		   leave.innerHTML=t;
	  }
</script>
  <body>
    <%
    	session.invalidate();
     %>
     <h3>您已退出系统，<span id="leave">3</span>秒后自动调转到登陆页面</h3>
     <h3>不能自动调转,请点击<a href="login.jsp">重新登陆</a></h3>
  </body>
</html>
