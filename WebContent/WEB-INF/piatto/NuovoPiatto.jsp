<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
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
	<!-- Java Script File -->
	<script type="text/javascript" src="/progetto/js/function.js"></script>
</head>
<body onload="delesectAll()">
	<div id="header">
		<p>
		<h1><s:text name="text.nuovoPiatto" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">
			<i class="fa fa-home fa-2x"></i>
		</button>	
	</div>
	<div id="content">
		<div id="mask">
			<s:form theme="css_xhtml" action="SalvaPiatto" namespace="/piatto">
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="nome" key="label.nome" requiredLabel="true" size="30"/>
					</div>
					<div class="col-md-4">
						<s:select name="categoria" key="label.categoria" requiredLabel="true" headerKey="-1" headerValue="Seleziona Categoria" 
									list="categorie" listKey="idCategoria" listValue="nome">	
						</s:select>				
					</div>
					<div class="col-md-4">
						<s:textfield name="prezzo" key="label.prezzo" requiredLabel="true" value="0,0"/>						
					</div>					
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="descrizione" key="label.descrizione" requiredLabel="true" size="70" />
					</div>							
				</div>
				<div class="row" id="space"></div>
				<div class="row">
					<div class="col-md-12">
						<s:textfield name="nomi_ingredienti" key="text.ingredientiSelezionati" readonly="true" size="150" />
					</div>	
					<div class="col-md-12">
						<s:textfield style="display:none;" name="id_ingredienti" readonly="true" size="150" />
					</div>					  
				</div>			
				<div class="row" id="space"></div>		
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/piatto/MenuPiatto'" value=<s:text name="btn.annulla"></s:text> />
					</div>
					<div class="col-md-2">						
						<input type="submit" value=<s:text name="btn.salva"></s:text> class="btn width-60"/>
					</div>
				</div>
			</s:form>
		</div>
		<s:actionmessage/>
		<s:actionerror/>		
		<div class="table">
			<h2><s:text name="label.ingredienti" />:</h2>
			<table id="table" class="table">	
				<tr id="intestazione">
					<td><s:text name="label.codice" /></td>
					<td><s:text name="label.nome" /></td>
					<td><s:text name="label.allergene" /></td>
					<td><s:text name="label.prezzo" /></td>
					<td><s:text name="label.seleziona" /></td>
				</tr>
				<s:iterator value="ingredienti">
					<tr id="dati" data-qaid='datarow' onclick="selectRow(this), printSelected()">						
						<td id="codice"><s:property value="idIngrediente" /></td>
						<td id="nome"><s:property value="nome" /></td>
						<td><s:property value="tipoAllergene" /></td>
						<td><s:property value="prezzo" />€</td>
						<td data-qaid='checkbox'><s:checkbox name="selezionato" fieldValue="true" theme="simple"/>
 					</tr>
				</s:iterator>				
			</table>	
		</div>
	</div>
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>