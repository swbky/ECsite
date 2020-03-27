<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserList画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>

		<div>
			<s:if test="userList.size().equals(0) || userList == null ">
				<h3>ユーザー情報はありません。</h3>
			</s:if>

			<s:elseif test="userList != null">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ログインID</th>
						<th>ログインパスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
					</tr>

					<s:iterator value="userList">
						<tr>
							<td>
								<a href='<s:url action="UserDetailAction"><s:param name="loginId"><s:property value="loginId"/></s:param></s:url>'><s:property value="loginId"/></a>
							</td>
							<td><s:property value="loginPassword"/></td>
							<td><s:property value="userName"/></td>
							<td><s:property value="insertDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
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