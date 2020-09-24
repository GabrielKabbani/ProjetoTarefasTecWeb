<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar tarefa</title>
</head>
<body>
<form action= 'adiciona' method = 'post'>
Tarefa: <input type = 'text' name='tarefa'><br>
Nível: <input type = 'number' name='nivel'><br>
Prazo (aaaa-mm-dd): <input type = 'date' name='prazo'><br>
<input type='hidden' name='criador' value='${param.usuario}'>
<input type='hidden' name='usuario' value='${param.usuario}'>
<input type='submit' value='adicionar'><br>
</form>

<form action = 'Lista'>
<input type='submit' value = 'voltar'>
</form>

</body>
</html>