<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemList画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>

		<div>
			<s:if test="itemInfoDTOList.size().equals(0) || itemInfoDTOList == null ">
				<h3>商品情報はありません。</h3>
			</s:if>

			<s:elseif test="itemInfoDTOList != null">
				<h3>商品情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>登録日</th>
					</tr>

					<s:iterator value="itemInfoDTOList">

						<tr>
							<td>
								<a href='<s:url action="ItemDetailAction"><s:param name="id"><s:property value="id"/></s:param></s:url>'><s:property value="itemName"/></a>
							</td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="itemStock"/><span>個</span></td>
							<td><s:property value="insertDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="ItemListDeleteConfirmAction">
					<s:submit value="全件削除"/>
				</s:form>
			</s:elseif>

			<div id="text-right">
				<p>管理者TOPへ戻る場合は
				<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>