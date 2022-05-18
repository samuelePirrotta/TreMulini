<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><s:text name="title.ingredienti" /></title>			
	<link rel="icon" type="image/x-icon" href="/progetto/img/icon.png">
	<!-- Bootstrap CSS CDN -->
	<link rel="stylesheet" type="text/css" href="/progetto/bootstrap/css/bootstrap.css">
	<!-- Font Awesome CSS -->
	<link rel="stylesheet" type="text/css" href="/progetto/fontawesome/css/all.css">
	<!-- Our Custom CSS -->
	<link rel="stylesheet" type="text/css" href="/progetto/css/style.css">
	<link rel="stylesheet" type="text/css" href="/progetto/css/style-struts2.css">
	<link rel="stylesheet" type="text/css" href="/progetto/css/style-header.css">
	<link rel="stylesheet" type="text/css" href="/progetto/css/style-mask.css">
	<script type="text/javascript" src="/progetto/js/function.js"></script>
</head>
<body>
	<div id="header">
		<p>
		<h1><s:text name="text.cercaIngrediente" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">	
			<i class="fa fa-home fa-2x"></i> 
		</button>		
	</div>	
	<div id=content>
		<div id="mask">
			<s:form theme="css_xhtml" action="CercaIngrediente" namespace="/ingrediente">
				<div class="row">
					<div class="col-md-3">				
						<s:textfield name="idIngrediente" key="label.codice" />
					</div>
					<div class="col-md-6">
						<s:textfield name="nome" key="label.nome" size="50" />
					</div>
					<div class="col-md-3">
						<s:radio name="allergene" key="label.allergene" list="{'Si', 'No'}"></s:radio>
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-3">
						<s:textfield name="tipoAllergene" key="label.tipoAllergene" />
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/ingrediente/MenuIngrediente'" value=<s:text name="btn.annulla"></s:text> />
					</div>
					<div class="col-md-2">
						<input type="submit" value=<s:text name="btn.cerca"></s:text> class="btn width-60"/>
					</div>
				</div>			
			</s:form>
		</div>
		<div class="table">
			<s:actionmessage/>
			<s:actionerror/>
			<table class="table">	
				<tr id="intestazione">
					<td><s:text name="label.codice" /></td>
					<td><s:text name="label.nome" /></td>
					<td><s:text name="label.allergene" /></td>
					<td><s:text name="label.tipoAllergene" /></td>
					<td><s:text name="label.prezzo" /></td>
				</tr>
				<s:iterator value="ingredienti">
					<tr id="dati" onclick="window.location.href='/progetto/ingrediente/ChiediModificaIngrediente?idIngrediente=${idIngrediente}'">						
						<td><s:property value="idIngrediente" /></td>
						<td><s:property value="nome" /></td>
						<s:if test="allergene">
							<s:set var="tipo">Si</s:set>
						</s:if>
						<s:else>
							<s:set var="tipo">No</s:set>
						</s:else>
						<td><s:property value="#tipo"/></td>
						<td><s:property value="tipoAllergene"/></td>
						<td><s:property value="prezzo"/>€</td>
 					</tr>
				</s:iterator>		
			</table>	
		</div>	
	</div>	
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>