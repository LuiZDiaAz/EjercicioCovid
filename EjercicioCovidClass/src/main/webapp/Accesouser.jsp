<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>Beneficio</title>
<%
HttpSession sesion = (HttpSession) request.getSession();
String benefi = String.valueOf(sesion.getAttribute("benefi"));
System.out.println("nombre: " + benefi + "");

if (benefi.equals(null) || benefi.equals("null")) {
	response.sendRedirect("index.jsp");
}
%>
</head>

<body class="bg-primary">
	<h1 align="center">Felicidades eres beneficiado con la vacuna
		contra el Covid-19</h1>
	<center>
		<button
			style="background-color: red; border-color: blue; color: white">Cerrar
		</button>
	</center>
</body>

</html>