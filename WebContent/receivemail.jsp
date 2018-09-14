<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ page import="java.util.* , model.vo.*"%>
<jsp:useBean id="dao" scope="page" class="model.dao.MessageDao"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>这是收件箱</title>
<style type="text/css">
body {
	background-color: #f5f7fa;
}

table {
	text-align: center;
	font-family: "微软雅黑";
	font-size: 14px;
}

p {
	font-family: "微软雅黑";
	font-size: 14px;
}

th {
	text-align: center;
	font-family: "微软雅黑";
	font-size: 16px;
}

a {
	color: #4b7ebd;
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}
</style>
<script type="text/javascript">
	function deleteChoice() {
		var allCb = document.getElementsByName("cbCheck");
		var flag = false;
		for (var i = 0; i < allCb.length; i++) {
			if (allCb[i].checked) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("至少选中一项");
			return;
		}
		if (confirm("是否确认删除？")) {
			var ids = "";
			for (var i = 0; i < allCb.length; i++) {
				if (allCb[i].checked) {
					ids = ids + allCb[i].value + ",";
				}
			}
			ids = ids.substring(0, ids.length - 1);
			window.location = "DeleteMail?id=" + ids;
		}
	}

	function deleteMail(Id) {
		if (confirm("是否确认删除该记录？")) {
			window.location = "DeleteMail?id=" + Id;
		}
	}
	function selectAll() {
		var a = document.getElementsByName("cbCheck");
		if (a[0].checked) {
			for (var i = 0; i < a.length; i++) {
				a[i].checked = true;
			}
		} else {
			for (var i = 0; i < a.length; i++) {
				a[i].checked = false;
			}
		}
	}
</script>
</head>
<%
	String status = null;
	List<Message> list = dao.queryMail(((User) session.getAttribute("User")).getUsername());
	Iterator<Message> iter = list.iterator();
%>
<body>
	<div style="margin-top: 50px; margin-left: 20px">
		<table width="950" border="1" cellspacing="0">
			<tr>
				<th width=50px><input type="checkbox" name="cbCheck"
					onclick="javascript:selectAll()" /></th>
				<th width="150px">发件人</th>
				<th width="250px">主题</th>
				<th width="250px">时间</th>
				<th width="100px">状态</th>
				<th width="150">操作</th>
			</tr>
			<%
				while (iter.hasNext()) {
					Message msg = iter.next();
					if (msg.getRead().equals("0"))
						status = "未读";
					if (msg.getRead().equals("1"))
						status = "已读";
			%>
			<tr>
				<td width=50px><input name="cbCheck" type="checkbox"
					value="<%=msg.getId()%>" /></td>
				<td><a href="sendmail.jsp?receiver=<%=msg.getSender()%>"><%=msg.getSender()%></a></td>
				<td><a href="mailview.jsp?id=<%=msg.getId()%>"><%=msg.getSubject()%></a></td>
				<td><%=msg.getTime()%></td>
				<td><%=status%></td>
				<td><a href="javascript:deleteMail('<%=msg.getId()%>')">删除</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<a href="javascript:deleteChoice()">批量删除</a>
		</p>
	</div>
</body>
</html>