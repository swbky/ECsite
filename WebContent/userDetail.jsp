<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserDetail画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>UserDetail</p>
		</div>

		<div>

				<h3>
					<s:iterator value="userList">
						<s:property value="userName"/>様の情報は以下になります。
					</s:iterator>
				</h3>
				<table border="1">
					<tr>
						<th>ログインID</th>
						<th>ログインパスワード</th>
						<th>ユーザー名</th>
						<th>属性</th>
						<th>登録日</th>
					</tr>

					<s:iterator value="userList">
						<tr>
							<td><s:property value="loginId"/></td>
							<td><s:property value="loginPassword"/></td>
							<td><s:property value="userName"/></td>
							<td><s:property value="adminFlg"/></td>
							<td><s:property value="insertDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
					<input type="hidden" name="loginId" value=<s:property value="loginId"/>>
					<s:submit value="１件削除"/>
				</s:form>

			<div id="text-right">
				<p>前画面へ戻る場合は
				<a href='<s:url action="UserListAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>