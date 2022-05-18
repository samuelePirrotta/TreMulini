<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><s:text name="title.utenti" /></title>			
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
		<h1><s:text name="text.modificaUtente" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">
			<i class="fa fa-home fa-2x"></i>
		</button>	
	</div>
	<div id="content">
		<div id="mask">
			<s:form theme="css_xhtml" action="ModificaUtente" namespace="/utente/secure">
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="idUtente" key="label.codice" requiredLabel="true" readonly="true" />
					</div>
					<div class="col-md-4">
						<s:textfield name="utente.nome" key="label.nome" requiredLabel="true" />
					</div>
					<div class="col-md-4">
						<s:textfield name="utente.mansione" key="label.mansione" requiredLabel="true" />
					</div>
				</div>								
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-4">
						<s:password name="utente.password" key="label.password" requiredLabel="true" showPassword="true"/>
					</div>
					<div class="col-md-4">
						<s:password name="confermaPassword" key="label.confermaPassword" requiredLabel="true" />
					</div>	
				</div>
				<div class="row" id="space"></div>		
				<div class="row">					
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/utente/secure/EliminaUtente?idUtente=${idUtente}'" value=<s:text name="btn.elimina"></s:text> />
					</div>
					<div class="col-md-6"></div>
					<div class="col-md-2">	
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/utente/secure/MenuUtente'" value=<s:text name="btn.annulla"></s:text> />				
					</div>
					<div class="col-md-2">						
						<input type="submit" value=<s:text name="btn.modifica"></s:text> class="btn width-60"/>
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