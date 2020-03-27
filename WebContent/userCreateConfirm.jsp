<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UserCreateConfirm画面</title>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url); /* URLに情報が送信される。（送信先が２つ以上あるときに便利 */
		$('form').submit();  /* $はjQueryを使うというサイン　submitで送信 */
	}
</script>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>

		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form>
					<tr id="box">
						<td>
							<label>ログインID</label>
						</td>
						<td>
							<s:property value="loginUserId" escape="false"/>   <!-- HTML文書として送る　テキストフォームになったりするのを防ぐため -->
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ログインPASS:</label>
						</td>
						<td>
							<s:property value="loginPassword" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ユーザー名:</label>
						</td>
						<td>
							<s:property value="userName" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>属性:</label>
						</td>
						<td>
							<s:property value='adminFlg' escape="false"/>
						</td>
					</tr>
					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('UserCreateAction')"/></td>
						<td><input type="button" value="完了" onclick="submitAction('UserCreateCompleteAction')"/></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>