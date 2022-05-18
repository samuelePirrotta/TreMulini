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
	<!-- Java Script File -->
	<script type="text/javascript" src="/progetto/js/function.js"></script>
</head>
<body>
	<div id="header">
		<p>
		<h1><s:text name="text.modificaBevanda" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">
			<i class="fa fa-home fa-2x"></i>
		</button>	
	</div>
	<div id="content">
		<div id="mask">
			<s:form theme="css_xhtml" action="ModificaBevanda" namespace="/bevanda">
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="bevanda.idBevanda" key="label.codice" readonly="true"/>						
					</div>
					<div class="col-md-4">
						<s:textfield name="bevanda.nome" key="label.nome" requiredLabel="true" size="30" />
					</div>
					<div class="col-md-4">
						<s:select name="categoria" key="label.categoria" requiredLabel="true" headerKey="-1" headerValue="Seleziona Categoria" 
									list="categorie" listKey="idCategoria" listValue="nome" value="bevanda.categoria.idCategoria">	
						</s:select>				
					</div>
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="bevanda.tipo" key="label.tipo" />
					</div>
					<div class="col-md-4">
						<s:textfield name="bevanda.pezzatura" key="label.pezzatura" requiredLabel="true" />
					</div>
					<div class="col-md-4">
						<s:textfield name="bevanda.costo" key="label.costo" requiredLabel="true" />						
					</div>														
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="bevanda.prezzo" key="label.prezzo" requiredLabel="true" />						
					</div>
					<div class="col-md-4">
						<s:textfield name="bevanda.cantina" key="label.cantina" />						
					</div>
				</div>
				<div class="row" id="space"></div>		
				<div class="row">					
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/bevanda/EliminaBevanda?idBevanda=${idBevanda}'" value=<s:text name="btn.elimina"></s:text> />
					</div>
					<div class="col-md-6"></div>
					<div class="col-md-2">	
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/bevanda/MenuBevanda'" value=<s:text name="btn.annulla"></s:text> />				
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