<%@page import="com.model2.mvc.service.domain.Purchase"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	Purchase purchase = (Purchase)request.getAttribute("purchase");
%>


<html>
<head>
<title>���� ���� Ȯ��</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=<%=purchase.getTranNo() %>" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><%=purchase.getPurchaseProd().getProdNo() %></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td><%=purchase.getBuyer().getUserId() %></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
			<%if(purchase.getPaymentOption().equals("1")){ %>
				���ݱ���
			<%}else if(purchase.getPaymentOption().equals("2")){ %>
				�ſ뱸��
			<%} %>
		
		</td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td><%=purchase.getReceiverName() %></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td><%=purchase.getReceiverPhone() %></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td><%=purchase.getDlvyAddr() %></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td><%=purchase.getDlvyRequest() %></td>
	</tr>
	<tr>
		<td>����������</td>
		<td><%=purchase.getDlvyDate() %></td>
	</tr>
</table>
</form>

</body>
</html>