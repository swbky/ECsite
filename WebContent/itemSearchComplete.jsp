<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style02.css">
<title>ItemSearchComplete画面</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>ItemSearchComplete</p>
		</div>

		<div>

			<s:if test="errorMessage != '' ">
				<s:property value="errorMessage" escape="false"/>
			</s:if>

			<div id="sort">
				<s:form action="SortAction">
					<select name="sort">
						<option value="1" selected="selected">価格の安い順</option>
						<option value="2">価格の高い順</option>
						<option value="3">新着順</option>
					</select>
					<div id="button">
						<s:submit value="並び替え"/>
					</div>
				</s:form>
			</div>

			<div id="list">
				<table>
					<s:iterator value="session.searchItemList">
					<s:form action="BuyItemAction">
						<tr>
							<td>
								<span>商品名</span>
							</td>
							<td>
								<s:property value="itemName"/>
							</td>
						</tr>
						<tr>
							<td>
								<span>値段</span>
							</td>
							<td>
								<s:property value="itemPrice"/>
								<span>円</span>
							</td>
						</tr>
						<tr>
							<td>
								<span>購入個数</span>
							</td>
							<td>
								<select name="count">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<span>支払い方法</span>
							</td>
							<td>
								<select name="pay">
									<option value="1" selected="selected">現金払い</option>
									<option value="2">クレジットカード</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="id" value="<s:property value="id"/>">
								<input type="hidden" name="itemName" value="<s:property value="itemName"/>">
								<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>">
								<s:submit value="この商品を購入"/>
							</td>
						</tr>
						<tr>
							<td>
								・・・・・・・・・・・・・・・
							</td>
							<td>
								・・・・・・・・・・・・・・・
							</td>
						</tr>
					</s:form>
					</s:iterator>
				</table>

			</div>


			<div>
				<p>条件検索をする場合は<a href='<s:url action="ItemSearchAction"/>'>こちら</a></p>
				<p>メニューへ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>

</body>
</html>