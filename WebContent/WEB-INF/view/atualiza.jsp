<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar tarefa</title>
</head>
<body>
<form action = 'atualiza' method = 'post'>
Tarefa: <input type = 'text' name='tarefa' value='${param.tarefa}'><br>
Nível: <input type = 'number' name='nivel' value='${param.nivel}'><br>
Prazo: <input type = 'text' name='prazo' value='${param.prazo}'><br>
Criador: <input type = 'text' name='criador' value='${param.criador}'><br>
<input type= 'hidden' name='id' value='${param.id}'>
<input type= 'submit' value='atualizar'>


</form>
</body>
</html>