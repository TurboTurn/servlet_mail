<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="model.dao.* , model.vo.* , java.util.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #f5f7fa;
}

table {
	text-align: center;
	font-family: "΢���ź�";
	font-size: 14px;
}

p {
	font-family: "΢���ź�";
	font-size: 14px;
}

th {
	text-align: center;
	font-family: "΢���ź�";
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
			alert("����ѡ��һ��");
			return;
		}
		if (confirm("�Ƿ�ȷ��ɾ����")) {
			var ids = "";
			for (var i = 0; i < allCb.length; i++) {
				if (allCb[i].checked) {
					ids = ids + allCb[i].value + ",";
				}
			}
			ids = ids.substring(0, ids.length - 1);
			window.location = "DeleteContact?id=" + ids;
		}
	}

	function deleteContact(Id) {
		if (confirm("�Ƿ�ȷ��ɾ���ü�¼��")) {
			window.location = "DeleteContact?id=" + Id;
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
	String username = ((User) session.getAttribute("User")).getUsername();
	ContactDao dao = new ContactDao();
	List<Contact> list = dao.queryContact(username);
	Iterator<Contact> iter = list.iterator();
%>
<body>
	<div style="margin-top: 50px; margin-left: 20px">
		<table width="950" border="1" cellspacing="0"
			style="text-align: center;">
			<tr>
				<th width="50px"><input type="checkbox" name="cbCheck"
					onclick="javascript:selectAll()" /></th>
				<th>�ǳ�</th>
				<th>����</th>
				<th>�绰</th>
				<th>����</th>
			</tr>
			<%
				while (iter.hasNext()) {
					Contact cont = iter.next();
			%>
			<tr>
				<td width="50px"><input type="checkbox" name="cbCheck"
					value="<%=cont.getId()%>" /></td>
				<td><%=cont.getContname()%></td>
				<td><a href="sendmail.jsp?receiver=<%=cont.getContid()%>"><%=cont.getContid()%></a></td>
				<td><%=cont.getContphone()%></td>
				<td><a href="updatecontact.jsp?id=<%=cont.getId()%>">�༭</a>
					&nbsp;<a href="javascript:deleteContact(<%=cont.getId()%>)">ɾ��</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<a href="addcontact.jsp">�����ϵ��</a>&nbsp;&nbsp;<a
				href="javascript:deleteChoice()">ɾ����ϵ��</a>
		</p>
	</div>
</body>
</html>