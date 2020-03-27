<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemDetail画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>ItemDetail</p>
		</div>

		<div>
			<h3>
				<s:iterator value="session.itemInfoDTOList">
					<s:property value="itemName"/>の情報は以下になります。
				</s:iterator>
			</h3>
			<table border="1">
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>値段</th>
					<th>在庫</th>
					<th>登録日</th>
				</tr>

				<s:iterator value="session.itemInfoDTOList">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/><span>円</span></td>
						<td><s:property value="itemStock"/><span>個</span></td>
						<td><s:property value="insertDate"/></td>
					</tr>
				</s:iterator>
			</table>
			<s:form action="StockAddAction">
				<input type="hidden" name="id" value=<s:property value="id"/>>
				<s:submit value="在庫数を変更する"/>
			</s:form>
			<s:form action="ItemListDeleteConfirmAction">
				<input type="hidden" name="id" value=<s:property value="id"/>>
				<s:submit value="１件削除"/>
			</s:form>

			<div id="text-right">
				<p>前画面へ戻る場合は
				<a href='<s:url action="ItemListAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>