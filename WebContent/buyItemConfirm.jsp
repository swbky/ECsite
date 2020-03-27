<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItemConfirm画面</title>
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
			<p>BuyItem</p>
		</div>

		<div>
			<s:form>
					<tr>
						<td>商品名</td>
						<td><s:property value="session.itemName"/></td>
					</tr>
					<tr>
						<td>値段</td>
						<td>
							<s:property value="session.itemPrice"/>
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>購入個数</td>
						<td>
							<s:property value="session.count"/>
							<span>個</span>
						</td>
					</tr>
					<tr>
						<td>合計金額</td>
						<td>
							<s:property value="session.total_price"/>
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>支払い方法</td>
						<td><s:property value="session.pay"/></td>
					</tr>


					<tr>
						<td><br></td>
					</tr>

					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
						<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
					</tr>
			</s:form>
		</div>

		<div>
			<p>前画面に戻る場合は
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			<p>マイページは
				<a href='<s:url action="MyPageAction"/>'>こちら</a></p>

		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>