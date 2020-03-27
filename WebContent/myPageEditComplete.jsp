<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>MyPageEditComplete画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>MyPageEditComplete</p>
		</div>

		<div>
			<h3><s:property value="message"/></h3>
			<div>
				<a href='<s:url action="LogoutAction"/>'>ホームへ戻る</a>
			</div>

		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>