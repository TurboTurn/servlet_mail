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
	
	table {
	 text-align: center;
	 font-family: "微软雅黑";
	font-size: 14px;
}
	p{
	 	font-family: "微软雅黑";
		font-size: 14px;	
	}
	th{
	text-align: center;
	 font-family: "微软雅黑";
	font-size: 16px;
	}
	a{
	color:#4b7ebd; 
	text-decoration:none; 
	}
	a:HOVER {
	text-decoration: underline;
</style>
<script type="text/javascript">
function deleteMail(Id){
	if(confirm("是否确认删除该记录？")){
		window.location="DeleteMail?id="+Id;
		
	}
	
}
</script>
</head>
<%
	String status=null;
	List<Message> list=dao.querySend(((User)session.getAttribute("User")).getUsername());
	Iterator<Message> iter=list.iterator();
%>
<body>
	<div style="margin-top: 50px;margin-left: 20px">
<table width="950" border="1" cellspacing="0">
	<tr>
		<th width=50px><input type="checkbox"/></th>
		<th width="150px">收件人</th>
		<th width="250px">主题</th>
		<th width="250px">时间</th>
		<th width="100px">状态</th>
		<th width="150">操作</th>
	</tr>
	<%
		while(iter.hasNext()){
			Message msg=iter.next();
			if(msg.getRead().equals("0"))
				status="未读";
			if(msg.getRead().equals("1"))
				status="已读";
	%>
	<tr>
		<td width=50px><input type="checkbox"/></td>
		<td><%=msg.getReceiver() %></td>
		<td><a href="mailview.jsp?id=<%=msg.getId() %>"><%=msg.getSubject() %></a></td>
		<td><%=msg.getTime() %></td>
		<td><%=status %></td>
		
		<td><a href="javascript:deleteMail(<%=msg.getId()%>)">删除</a></td>
	</tr>
	<%
		}
	%>
</table>
</div>
</body>
</html>