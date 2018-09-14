<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ page import="java.util.* , model.vo.*"%>
<jsp:useBean id="dao" scope="page" class="model.dao.MessageDao"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�����ռ���</title>
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
			window.location = "DeleteMail?id=" + ids;
		}
	}

	function deleteMail(Id) {
		if (confirm("�Ƿ�ȷ��ɾ���ü�¼��")) {
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
				<th width="150px">������</th>
				<th width="250px">����</th>
				<th width="250px">ʱ��</th>
				<th width="100px">״̬</th>
				<th width="150">����</th>
			</tr>
			<%
				while (iter.hasNext()) {
					Message msg = iter.next();
					if (msg.getRead().equals("0"))
						status = "δ��";
					if (msg.getRead().equals("1"))
						status = "�Ѷ�";
			%>
			<tr>
				<td width=50px><input name="cbCheck" type="checkbox"
					value="<%=msg.getId()%>" /></td>
				<td><a href="sendmail.jsp?receiver=<%=msg.getSender()%>"><%=msg.getSender()%></a></td>
				<td><a href="mailview.jsp?id=<%=msg.getId()%>"><%=msg.getSubject()%></a></td>
				<td><%=msg.getTime()%></td>
				<td><%=status%></td>
				<td><a href="javascript:deleteMail('<%=msg.getId()%>')">ɾ��</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<a href="javascript:deleteChoice()">����ɾ��</a>
		</p>
	</div>
</body>
</html>