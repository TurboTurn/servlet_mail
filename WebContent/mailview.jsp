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
	span,p{
	font-family:'Microsoft YaHei';
	font-size: 12px;
	}
</style>
</head>
<%
	String id=request.getParameter("id");
	MessageDao dao=new MessageDao();
	dao.updateRead(id);
	Message msg=dao.queryMailDetail(id);
	
%>
<body>
<div>
	<h2>���⣺<%=msg.getSubject() %></h2>
	<p>�����ˣ�<%=msg.getSender() %></p>
	<p>ʱ�䣺<%=msg.getTime() %></p>
	<p>�ռ��ˣ�<%=msg.getReceiver() %></p>
	<span style="font-size:16px">���ģ�<%=msg.getText() %></span>
	<p>״̬��<%=msg.getRead() %></p>
</div>
</body>
</html>