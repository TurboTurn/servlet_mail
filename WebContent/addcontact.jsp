<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page  import="model.dao.* , model.vo.* , java.util.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color: #f5f7fa;
	}
</style>
</head>
<body>
<form action="AddContact" method="post">
	<div>
		<p>昵称<input type="text" name="contname" /></p>
		<p>邮箱<input type="text" name="contid" /></p>
		<p>电话<input type="text" name="contphone" /></p>
		<input type="submit" value="确认添加"/>
	</div>
</form>
</body>
</html>