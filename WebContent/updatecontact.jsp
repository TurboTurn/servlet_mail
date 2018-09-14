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
<%	
	/*String contname=request.getParameter("contname");
	contname=new String(contname.getBytes("iso8859-1"),"gb2312");
	String contid=request.getParameter("contid");
	String contphone=request.getParameter("contphone");*/
	String id=request.getParameter("id");
	ContactDao dao=new ContactDao();
	Contact cont=dao.queryCont(id);
%>
<body>
<form action="UpdateContact" method="post">
	<div>
		<p>昵称<input type="text" name="newname" value="<%=cont.getContname() %>"/></p>
		<p>邮箱<input type="text" name="newid" value="<%=cont.getContid() %>"/></p>
		<p>电话<input type="text" name="newphone" value="<%=cont.getContphone() %>"/></p>
		<input type="hidden" name="username" value="${User.username }"/>
		<input type="hidden" name="id" value="<%=cont.getId()%>"/>
		<input type="submit" value="确认修改"/>
	</div>
</form>
</body>
</html>