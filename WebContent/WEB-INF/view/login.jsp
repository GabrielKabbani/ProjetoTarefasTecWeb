<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<em>Insira seus credenciais para entrar:</em><br>
<% if (request.getAttribute("errou") == "true") {%>
<b>Senha inválida, tente novamente</b>
<%} %>
<body>
<form action= 'usuarios' method = 'post'>
Usuário: <input type = 'text' name='usuario'><br>
Senha: <input type = 'text' name='senha'><br>
<input type='submit' value='Entrar'><br>
</form>
<form action= 'newUser' method = 'get'>
<input type='submit' value='Criar novo usuário'><br>
</form>
</body>
</html>