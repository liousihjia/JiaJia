<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<script>
var ajson =  {"name":"mkyong","salary":7500,"skills":["java","python"]};

var url = "openjson";
var form = document.createElement("form");  
form.action = url;  
form.method = "POST";  
form.target = "_blank";  
var input = document.createElement("textarea");
input.name = "result";
input.value = JSON.stringify(ajson);
form.appendChild(input);  
form.style.display = 'none';  
form.enctype='application/json';  
document.body.appendChild(form);  
form.submit();  
document.body.removeChild(form); 

</script>
</body>
</html>
