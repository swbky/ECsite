<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemListDeleteConfirm画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>

		<div>
				<h3>商品ID【<s:property value="id"/>】の商品を削除します。よろしいでしょうか？</h3>
				<table>
					<tr>
						<th>
							<s:form action="ItemListDeleteCompleteAction">
								<input type="hidden" name="id" value=<s:property value="id"/>>
								<s:submit value="OK"/>
							</s:form>
						</th>

						<th>
							<s:form action="ItemDetailAction">
								<input type="hidden" name="id" value=<s:property value="id"/>>
								<s:submit value="キャンセル"/>
							</s:form>
						</th>
					</tr>
				</table>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>