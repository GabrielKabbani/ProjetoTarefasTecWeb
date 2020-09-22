<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*, br.edu.insper.mvc.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefas</title>
</head>
<body>
<jsp:useBean id="dao" class="br.edu.insper.mvc.model.DAO"/>

<table border='1'>
<tr>
	<td><b>#</b></td>
	<td><b>tarefa</b></td>
	<td><b>nivel</b></td>
	<td><b>criador</b></td>
	<td><b>data</b></td>
</tr>

<c:forEach var="tarefa" items="${dao.lista}" varStatus="id"> 
<tr>
	<td>${id.count}</td>
	<td>${tarefa.tarefa}</td>
	<td>${tarefa.nivel}</td>
	<td>${tarefa.criador}</td>
	<td>${tarefa.data}</td>
</c:forEach>
</table>

<form action= 'main' method = 'post'>
Tarefa: <input type = 'text' name='tarefa'><br>
Nível: <input type = 'number' name='nivel'><br>
Prazo: <input type = 'date' name='prazo'><br>
Criador: <input type = 'text' name='criador'><br>
</form>
<% Tarefas tarefa = new Tarefas(); %>
<% tarefa.setTarefa(request.getParameter("tarefa")); %>
<% tarefa.setNivel(Integer.valueOf(request.getParameter("nivel"))); %>
<% tarefa.setCriador(request.getParameter("criador")); %>
<%-- <% String data = request.getParameter("prazo");%>
<% Date prazo = new SimpleDateFormat("yyyy-MM-dd").parse(data);%> --%>
<% dao.adiciona(tarefa); %>




</body>
</html>