<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>

		<div>
			<h3>マイページ編集画面へアクセスするにはパスワードを入力して下さい。</h3>
			<s:form action="MyPageEditAction">
				<input type="text" name="loginUserId" value=<s:property value="session.login_user_id"/>>
				<s:password name="loginPassword"/>
				<s:submit value="ログイン"/>
			</s:form>
			<br/>
			<div id="text-link">
				<p>マイページへ戻る場合は
					<a href='<s:url action="MyPageAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>