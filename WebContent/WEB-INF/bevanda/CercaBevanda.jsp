<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><s:text name="title.bevande" /></title>			
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
		<h1><s:text name="text.cercaBevanda" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">	
			<i class="fa fa-home fa-2x"></i> 
		</button>		
	</div>	
	<div id=content>
		<div id="mask">
			<s:form theme="css_xhtml" action="CercaBevanda" namespace="/bevanda">
				<div class="row">
					<div class="col-md-3">				
						<s:textfield name="idBevanda" key="label.codice" />
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
						<s:textfield name="tipo" key="label.tipo" />
					</div>				
					<div class="col-md-3">
						<s:textfield name="cantina" key="label.cantina" />						
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/bevanda/MenuBevanda'" value=<s:text name="btn.annulla"></s:text> />
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
					<td><s:text name="label.tipo" /></td>
					<td><s:text name="label.pezzatura" /></td>
					<td><s:text name="label.prezzo" /></td>
					<td><s:text name="label.cantina" /></td>
				</tr>
				<s:iterator value="bevande">
					<tr id="dati" onclick="window.location.href='/progetto/bevanda/ChiediModificaBevanda?idBevanda=${idBevanda}'" >						
						<td><s:property value="idBevanda" /></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="categoria.nome" /></td>
						<td><s:property value="tipo" /></td>
						<td><s:property value="pezzatura" />cl</td>
						<td><s:property value="prezzo" />€</td>
						<td><s:property value="cantina" /></td>
 					</tr>
				</s:iterator>				
			</table>	
		</div>	
	</div>	
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>