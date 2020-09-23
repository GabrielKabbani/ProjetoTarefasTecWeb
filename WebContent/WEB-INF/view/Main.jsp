<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*, br.edu.insper.mvc.model.*" %>
<%@ page import="java.util.*, br.edu.insper.mvc.controller.*" %>
<%@ page import="java.text.*" %>
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
	<td><b>prazo</b></td>
</tr>

<c:forEach var="tarefa" items="${dao.lista}" varStatus="id"> 
<tr>
	<td>${id.count}</td>
	<td>${tarefa.tarefa}</td>
	<td>${tarefa.nivel}</td>
	<td>${tarefa.criador}</td>
	<td>${tarefa.prazo}</td>
	<td>
	<form action='remove' method='post'>
	<input type='hidden' name='id' value='${tarefa.id}'>
	<input type='submit' value='remover'>
	</form>
	<form action='atualiza' method='get'>
	<input type='hidden' name='id' value='${tarefa.id}'>
	<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
	<input type='hidden' name='prazo' value='${tarefa.prazo}'>
	<input type='hidden' name='nivel' value='${tarefa.nivel}'>
	<input type='hidden' name='criador' value='${tarefa.criador}'>
	<input type='submit' value='atualizar'>
	</form>
	</td>
	
</tr>
</c:forEach>
</table>

<form action='adiciona' method='get'>
	<input type='hidden' name='id' value='${tarefa.id}'>
	<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
	<input type='hidden' name='prazo' value='${tarefa.prazo}'>
	<input type='hidden' name='nivel' value='${tarefa.nivel}'>
	<input type='hidden' name='usuario' value='${param.usuario}'>
	<input type='submit' value='adicionar'>
</form>

</body>
</html>