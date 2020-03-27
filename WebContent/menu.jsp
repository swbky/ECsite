<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Menu画面</title>
</head>

<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>Menu</p>
		</div>

		<div id="text-center">
			<s:form action="ItemSearchAction">
				<s:submit value="商品検索"/>
			</s:form>
			<s:form action="ItemSearchCompleteAction">
			<input type="hidden" name="itemName" value=""/>
			<input type="hidden" name="priceAbove" value=""/>
			<input type="hidden" name="priceBelow" value=""/>
				<s:submit value="商品一覧"/>
			</s:form>
		</div>

		<div id="text-right">
				<p>Homeへ戻る場合は
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>