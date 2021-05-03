<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<head>
<meta charset="UTF-8">
<title>Lo sentimos</title>
</head>
<body class="bg-primary">
	<%
	HttpSession sesion = (HttpSession) request.getSession();
	String consulta = String.valueOf(sesion.getAttribute("Consulta"));
	String usuSession = String.valueOf(sesion.getAttribute("nombre"));

	if (consulta.equals("Consulta") || usuSession.equals(null) || usuSession.equals("null")) {

		response.sendRedirect("index.jsp");

	}
	%>
	<div class="col-lg-12 color">
		<center>
			<h3>Lo sentimos no eres candidato a la vacuna contra el COVID-19</h3>
		</center>
		</form>
	</div>
	<div class="p-5">
		<center>
			<form action="ControllerUser" method="post">
				<button class="btn btn-success " name="btnConsultar"
					value="Consultar">
					<i class="fa fa-location-arrow"></i> Nueva consulta
				</button>
			</form>
		</center>
	</div>
</body>
</html>