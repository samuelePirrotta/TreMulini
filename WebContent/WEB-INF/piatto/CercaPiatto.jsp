<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head/> 
	<meta charset="utf-8">
	<title><s:text name="title.piatti" /></title>		
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
		<h1><s:text name="text.cercaPiatto" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">	
			<i class="fa fa-home fa-2x"></i> 
		</button>		
	</div>	
	<div id=content>
		<div id="mask">
			<s:form theme="css_xhtml" action="CercaPiatto" namespace="/piatto">
				<div class="row">
					<div class="col-md-3">				
						<s:textfield name="idPiatto" key="label.codice" />
					</div>
					<div class="col-md-6">
						<s:textfield name="nome" key="label.nome" size="50" />
					</div>
					<div class="col-md-3">						
						<s:select name="categoria" key="label.categoria" headerKey="-1" headerValue="Seleziona Categoria" 
									list="categorie" listKey="idCategoria" listValue="nome">	
						</s:select>						
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">	
					<div class="col-md-3">
						<s:textfield name="descrizione" key="label.descrizione" size="70"/>
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/piatto/MenuPiatto'" value=<s:text name="btn.annulla"></s:text> />
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
					<td><s:text name="label.categoria" /></td>
					<td><s:text name="label.descrizione" /></td>
					<td><s:text name="label.prezzo" /></td>
				</tr>
				<s:iterator value="piatti">
					<tr id="dati" onclick="window.location.href='/progetto/piatto/ChiediModificaPiatto?idPiatto=${idPiatto}'" >						
						<td><s:property value="idPiatto" /></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="categoria.nome" /></td>
						<td><s:property value="descrizione" /></td>
						<td><s:property value="prezzo" />€</td>
 					</tr>
				</s:iterator>				
			</table>	
		</div>	
	</div>	
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>