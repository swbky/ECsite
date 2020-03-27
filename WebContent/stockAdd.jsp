<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserCreate画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>StockAdd</p>
		</div>

		<div>
			<s:if test="errorMessage != '' ">
				<s:property value="errorMessage" escape="false"/>
			</s:if>

				<h3>在庫数を入力して下さい。</h3>


			<table>
				<s:form action="StockAddConfirmAction">
					<tr>
						<td>
							<label>在庫数:</label>
						</td>
						<td>
							<input type="text" name="stock" value=""/>
						</td>
					</tr>
					<s:submit value="OK"/>
				</s:form>
			</table>

			<div>
				<span>商品一覧画面へ戻る場合は</span>
				<a href='<s:url action="ItemListAction"/>'>こちら</a>
				<p>管理者TOPへ戻る場合は
				<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>

		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>