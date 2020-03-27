<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>MyPageEdit画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>MyPageEdit</p>
		</div>

		<div>
			<s:if test="errorMessage != '' ">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<s:form action="MyPageEditConfirmAction">
					<tr>
						<td>
							<label>ログインID:</label>
						</td>
						<td>
							<input type="text" name="loginUserId" value=<s:property value="session.oldLoginId"/>>
						</td>
					</tr>
					<tr>
						<td>
							<label>ログインPASS:</label>
						</td>
						<td>
							<input type="text" name="loginPassword" value=<s:property value="session.loginPassword"/>>
						</td>
					</tr>
					<tr>
						<td>
							<label>ユーザー名:</label>
						</td>
						<td>
							<input type="text" name="userName" value=<s:property value="session.userName"/>>
						</td>
					</tr>
					<s:submit value="登録"/>
				</s:form>
			</table>

			<div>
				<span>マイページへ戻る場合は</span>
				<a href='<s:url action="MyPageAction"/>'>こちら</a>
			</div>

		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>