<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemSearch画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>ItemSearch</p>
		</div>

		<div>
			<table>
				<s:form action="ItemSearchCompleteAction">
					<tr>
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<input type="text" name="itemName" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<label>値段:</label>
						</td>
						<td>
							<input type="text" name="priceAbove" value=""/>  円以上
						</td>
					</tr>
					<tr>
						<td>
							<label></label>
						</td>
						<td>
							<input type="text" name="priceBelow" value=""/>  円以下
						</td>
					</tr>

					<s:submit value="検索"/>
				</s:form>
			</table>

			<div>
				<span>メニューへ戻る場合は</span>
				<a href='<s:url action="HomeAction"/>'>こちら</a>
			</div>

		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>