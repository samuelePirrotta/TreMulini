<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="refresh" content="1;url=<s:url />"/>
	<title><s:text name="title" /></title>
	<link rel="icon" type="image/x-icon" href="/progetto/img/icon.png">
	<link type="text/css" rel="stylesheet" href="/progetto/css/style.css">
</head>
<body>
	<div class="center">
		<img 	src="/progetto/img/loading.gif" />
		<h3>
			<s:text name="text.wait" />
		</h3>
	</div>
</body>
</html>
