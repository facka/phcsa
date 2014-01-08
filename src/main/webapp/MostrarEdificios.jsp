<!DOCTYPE html>
<html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.arco.phcsa.dominio.Edificio"%>
<%@page import="com.arco.phcsa.dominio.Unidad"%>
<%@page import="java.util.List"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Edificios</title>
</head>
<body>
	Hola Edificios
	</br>
	<%
	List<Edificio> listaDeEdificios = (List<Edificio>)request.getAttribute("edificios");
	
	for(Edificio edificio:listaDeEdificios){
	  %>
	<h1><%=edificio.getIdEdificio()+": "+edificio.getDireccion()%></h1>
	<ul>
	<% for(Unidad unidad : edificio.getUnidades()) {%>
		<li><%=unidad.getIdUnidad()+": "+unidad.getNumero()+" - "+ unidad.getDireccionExtendida()%></li>
	</ul>
	</br>
	<%} %>
	<%} %> 
</body>
</html>






