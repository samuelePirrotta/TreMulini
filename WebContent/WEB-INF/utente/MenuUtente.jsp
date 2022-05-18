<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">	
	<title><s:text name="title.utenti" /></title>			
	<link rel="icon" type="image/x-icon" href="/progetto/img/icon.png">	
	<!-- Bootstrap CSS CDN -->
	<link rel="stylesheet" type="text/css" href="/progetto/bootstrap/css/bootstrap.css">
	<!-- Font Awesome CSS -->
	<link rel="stylesheet" type="text/css" href="/progetto/fontawesome/css/all.css">
	<!-- Our Custom CSS -->
	<link rel="stylesheet" type="text/css" href="/progetto/css/style.css">
	<link rel="stylesheet" type="text/css" href="/progetto/css/style-home.css">
	<!--  Our JavaScript File -->
	<script type="text/javascript" src="/progetto/js/function.js"></script>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/includeFile/navBar.txt"%>
		<!-- Page Content Holder -->
		<div id="content">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
							<label class="label"><s:text name="text.utenti" /></label>				
					</div>
					<div class="col-md-12 text-center">
							<img class="resize" src="/progetto/img/utenti.png" />
					</div>
				</div>
				<div class="row">	
					<div class="col-md-2 text-center"></div>				
					<div class="col-md-4 text-center">
						<a href="/progetto/utente/secure/NuovoUtente">
							<div class="service">
								<i class="fas fa-plus fa-2x" area-hidden="true"></i>
								<h4>
									<s:text name="text.nuovo" />
								</h4>
							</div>
						</a>
					</div>
					<div class="col-md-4 text-center">
						<a href="/progetto/utente/secure/ChiediCercaUtente">
							<div class="service">
								<i class="fas fa-search fa-2x" area-hidden="true"></i>
								<h4>
									<s:text name="text.cerca" />
								</h4>
							</div>
						</a>
					</div>
					<div class="col-md-2 text-center"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/includeFile/footer.txt"%>
	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
			$(document).ready(function() {
				$('#sidebarCollapse').on('click', function() {
					$('#sidebar').toggleClass('active');
					$(this).toggleClass('active');
				});
			});
	</script>
</body>
</html>