<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!--Forza Microsoft Edge ad eseguire il rendering avanzato-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">		
    	<title><s:text name="title.login" /></title>    				
		<link rel="icon" type="image/x-icon" href="/progetto/img/icon.png">
		<!-- Bootstrap CSS CDN -->
		<link rel="stylesheet" type="text/css" href="/progetto/bootstrap/css/bootstrap.css">
		<!-- Our Custom CSS -->
    	<link type="text/css" rel="stylesheet" href="/progetto/css/style.css" >
    	<link type="text/css" rel="stylesheet" href="/progetto/css/style-login.css" >
	</head>
	<body>
		<s:form class="form-signin" action="Login" namespace="/utente">
			<div class="center">					
				<img class="mb-4" src="/progetto/img/logo.png" width="250" height=auto>
				<h4>Login</h4>
				<br />
			</div>
	    	<s:textfield cssClass="form-control" name="username" label="Username" labelposition="top"/>
	    	<s:password cssClass="form-control" name="password" label="Password" labelposition="top"/>
	    	<s:submit key="btn.submit" cssClass="btn btn-lg btn-primary btn-block"/>
		</s:form>	    
	    <!-- Script JS Bootstrap -->
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
	</body>	
</html>
<!-- Se si vuole che i messaggi di validazione compaiano in un punto specifico della pagina --> <!--  <div><s:fielderror/></div> --> 