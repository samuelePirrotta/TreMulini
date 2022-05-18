<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><s:text name="title.ordini" /></title>		
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
		<h1><s:text name="text.nuovoOrdine" /></h1>
		<button class="icon-btn" id="home-btn" onclick="window.location.href='/progetto/utente/secure/Authenticated'">
			<i class="fa fa-home fa-2x"></i>
		</button>	
	</div>
	<div id="content">
		<div id="mask">
			<s:form theme="css_xhtml" action="AggiungiElemento" namespace="/ordine">
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="tavolo" key="label.tavolo" requiredLabel="true" size="30" />
					</div>
					<div class="col-md-4">
						<s:select name="piatto" key="label.piatto" headerKey="-1" headerValue="Seleziona Piatto" 
									list="piatti" listKey="idPiatto" listValue="nome">	
						</s:select>
					</div>
					<div class="col-md-4">
						<s:select name="bevanda" key="label.bevanda" headerKey="-1" headerValue="Seleziona Bevanda" 
									list="bevande" listKey="idBevanda" listValue="nome">	
						</s:select>				
					</div>				
				</div>
				<div class="row" id="space"></div>	
				<div class="row">
					<div class="col-md-4">
						<s:textfield name="quantita" key="label.quantita" requiredLabel="true" size="30" />
					</div>
					<div class="col-md-4">
						<s:textfield name="totale" key="label.totale" readonly="true" />
					</div>
				</div>
				<div class="row" id="space"></div>	
				<div class="row">
					<div class="col-md-4">
						<s:textarea name="note" key="label.note" size="30" />
					</div>
				</div>
				<div class="row" id="space"></div>		
				<div class="row">
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/ordine/SalvaOrdine?tavolo=${tavolo}&note=${note}&totale=${totale}'" 
						value=<s:text name="btn.salva"></s:text> />
					</div>
					
					<div class="col-md-6"></div>
					<div class="col-md-2">
						<input type="button" class="btn width-60" onclick="window.location.href='/progetto/utente/secure/Authenticated'" value=<s:text name="btn.annulla"></s:text> />
					</div>
					<div class="col-md-2">						
						<input type="submit" value=<s:text name="btn.aggiungi"></s:text> class="btn width-60"/>
					</div>
				</div>
			</s:form>
		</div>
		<s:actionmessage/>
		<s:actionerror/>		
		<div class="table">
			<s:set var="piattiSalvati" value="piattiAggiunti" scope="session"></s:set>			
			<h2><s:text name="label.piattiAggiunti" />:</h2>
			<table id="tablePiatti" class="table">	
				<tr id="intestazione">
					<td><s:text name="label.codice" /></td>
					<td><s:text name="label.nome" /></td>
					<td><s:text name="label.descrizione" /></td>
					<td><s:text name="label.categoria" /></td>
					<td><s:text name="label.prezzoUnitario" /></td>
					<td><s:text name="label.quantita" /></td>
					<td><s:text name="label.prezzo" /></td>
				</tr>
				<s:iterator value="piattiAggiunti" status="sta">
					<tr id="dati">
						<td><s:property value="piatto.idPiatto"/></td>
						<td><s:property value="piatto.nome" /></td>
						<td><s:property value="piatto.descrizione" /></td>
						<td><s:property value="piatto.categoria.nome" /></td>
						<td><s:property value="piatto.prezzo" /> €</td>
						<td><s:property value="quantita" /></td>
						<td><s:property value="prezzo" /> €</td>
 					</tr>
				</s:iterator>			
			</table>	
		</div>
		<br /> <br />
		<div class="table">
			<s:set var="bevandeSalvate" value="bevandeAggiunte" scope="session"></s:set>
			<h2><s:text name="label.bevandeAggiunte" />:</h2>
			<table id="tableBevande" class="table">	
				<tr id="intestazione">
					<td><s:text name="label.codice"></s:text>
					<td><s:text name="label.nome" /></td>
					<td><s:text name="label.categoria" /></td>
					<td><s:text name="label.tipo" /></td>
					<td><s:text name="label.prezzoUnitario" /></td>
					<td><s:text name="label.quantita" /></td>
					<td><s:text name="label.prezzo" /></td>
				</tr>
				<s:iterator value="bevandeAggiunte">
					<tr id="dati">	
						<td><s:property value="bevanda.idBevanda" /></td>					
						<td><s:property value="bevanda.nome" /></td>
						<td><s:property value="bevanda.categoria.nome" /></td>		
						<td><s:property value="bevanda.tipo" /></td>
						<td><s:property value="bevanda.prezzo" /> €</td>
						<td><s:property value="quantita" /></td>
						<td><s:property value="prezzo" /> €</td>
 					</tr>
				</s:iterator>				
			</table>	
		</div>
	</div>
	<%@ include file="/includeFile/footer.txt" %>	
</body>
</html>