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
	<!-- Java Script File -->
	<script type="text/javascript" src="/progetto/js/function.js"></script>
</head>
<body>
	<div id="header">
		<p>
		<h1><s:text name="text.nuovoIngrediente" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">
			<i class="fa fa-home fa-2x"></i>
		</button>	
	</div>
	<div id="content">
		<div id="mask">
			<s:form theme="css_xhtml" action="SalvaIngrediente" namespace="/ingrediente">
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="nome" key="label.nome" requiredLabel="true" size="30" />
					</div>
					<div class="col-md-3">
						<s:textfield name="prezzo" key="label.prezzo" requiredLabel="true" value="0,0"/>
					</div>	
					<div class="col-md-3">
						<s:radio name="allergene" key="label.allergene" requiredLabel="true" list="{'Si', 'No'}"></s:radio>
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
						<input type="submit" value=<s:text name="btn.salva"></s:text> class="btn width-60"/>
					</div>
				</div>
			</s:form>
		</div>
		<s:actionmessage/>
		<s:actionerror/>
	</div>	
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>