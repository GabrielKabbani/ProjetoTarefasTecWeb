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
<form action='Lista'>
<label for="cars">Qual categoria você deseja buscar?:</label>
  <select name="categoria">
    <option value="tarefa">Nome da tarefa</option>
    <option value="prazo">Prazo</option>
    <option value="nivel">Nível de importância</option>
  </select>
O que você deseja buscar?: <input type='text' name='query'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='buscar'> 
</form>
<form action='Lista'>
<input type='hidden' name='imp' value='imp_asc'>
<input type='hidden' name='dat' value='normal'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='Ordenar por nível de importância crescente'>
</form>
<form action='Lista'>
<input type='hidden' name='imp' value='imp_desc'>
<input type='hidden' name='dat' value='normal'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='Ordenar por nível de importância decrescente'>
</form>
<form action='Lista'>
<input type='hidden' name='dat' value='dat_asc'>
<input type='hidden' name='imp' value='normal'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='Ordenar por nível de data crescente'>
</form>
<form action='Lista'>
<input type='hidden' name='dat' value='dat_desc'>
<input type='hidden' name='imp' value='normal'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='Ordenar por nível de data decrescente'>
</form>
<table border='1'>
<tr>
	<td><b>#</b></td>
	<td><b>Tarefa</b></td>
	<td><b>Nível</b></td>
	<td><b>Criador</b></td>
	<td><b>Prazo</b></td>
</tr>

<c:forEach var="tarefa" items="${tarefas}" varStatus="id"> 
<tr>
	<td>${id.count}</td>
	<td>${tarefa.tarefa}</td>
	<td>${tarefa.nivel}</td>
	<td>${tarefa.criador}</td>
	<td>${tarefa.prazo}</td>
	<td>
	<form action='remove' method='post'>
	<input type='hidden' name='id' value='${tarefa.id}'>
	<input type='hidden' name='usuario' value='${param.usuario}'>
	<input type='submit' value='remover'>
	</form>
	<form action='atualiza' method='get'>
	<input type='hidden' name='id' value='${tarefa.id}'>
	<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
	<input type='hidden' name='prazo' value='${tarefa.prazo}'>
	<input type='hidden' name='nivel' value='${tarefa.nivel}'>
	<input type='hidden' name='criador' value='${tarefa.criador}'>
	<input type='hidden' name='usuario' value='${param.usuario}'>
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

<form action='usuarios' method='get'>
<input type='submit' value='logout'>
</form>

</body>
</html>