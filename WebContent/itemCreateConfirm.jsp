<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>ItemCreateConfirm画面</title>
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
			<p>ItemCreateConfirm</p>
		</div>

		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form>
					<tr id="box">
						<td>
							<label>商品名：</label>
						</td>
						<td>
							<s:property value="itemName" escape="false"/>   <!-- HTML文書として送る　テキストフォームになったりするのを防ぐため -->
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>値段:</label>
						</td>
						<td>
							<s:property value="itemPrice" escape="false"/>円
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>在庫:</label>
						</td>
						<td>
							<s:property value="itemStock" escape="false"/>個
						</td>
					</tr>
					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('ItemCreateAction')"/></td>
						<td><input type="button" value="完了" onclick="submitAction('ItemCreateCompleteAction')"/></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>