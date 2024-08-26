<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://cdn.tailwindcss.com"></script>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">


<link href="https://cdn.jsdelivr.net/npm/flowbite@2.5.1/dist/flowbite.min.css" rel="stylesheet" />

<link rel="icon" type="images/png" href="images/favIcon.png">
<script src="js/jquery-3.7.1.min.js"></script>
<script src="js/anim.js"></script>
<title>Inventory System</title>
</head>
<body>

	<jsp:include page="pages/header.jsp"></jsp:include>	
	
	<div id="divMenu"></div>
	<div id="divMain">
	<jsp:include page="pages/login.jsp"></jsp:include>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/flowbite@2.5.1/dist/flowbite.min.js"></script>
</body>
</html>