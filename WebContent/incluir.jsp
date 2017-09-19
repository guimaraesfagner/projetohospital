<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	page import="java.util.List" %>
<%@	page import="model.Lazer" %>
<%@	page import="model.Escolaridade" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pacientes</title>
</head>
<body>
	<h1>Cadastro de Pacientes</h1>
	<h3>Inclusão de Novo Paciente</h3>
	<form action="ManagerPaciente" method="post">
	<input type=hidden name=metodo value=IncluirPaciente />
	<table border="1">
		<tr>
			<td>Nome</td>
			<td><input type="text" name="nome" size="30" /></td>
		</tr>
		<tr>
			<td>Idade</td>
			<td><input type="text" name="idade" size="2" /></td>
		</tr>
		<tr>
			<td>Sexo</td>
			<td><input type="radio" name="sexo" value="M" /> M &nbsp; <input type="radio" name="sexo" value="F" /> F</td>
		</tr>
		<tr>
			<td>Lazer</td>
			<td><select name="lazer">
				<%
				List<Lazer> listagemLazer;

				listagemLazer = (List<Lazer>) request.getAttribute("LISTA_LAZER");				
				for (int i = 0; i < listagemLazer.size(); i++) { %>

					<option value="<%= listagemLazer.get(i).getId()%>"><%= listagemLazer.get(i).getDescricao()%></option>
				<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td>Escolaridade</td>
			<td><select name="escolaridade">
				<%
				List<Escolaridade> listagemEscolaridade;
				
				listagemEscolaridade = (List<Escolaridade>) request.getAttribute("LISTA_ESCOLARIDADE");
				for (int i = 0; i < listagemEscolaridade.size(); i++) { %>
				
					<option value="<%= listagemEscolaridade.get(i).getId()%>"><%= listagemEscolaridade.get(i).getDescricao()%></option>
				<% } %>
				</select>
			</td>
		</tr>
	</table>
	<input type="submit" value="Enviar" />
	<a href="cadastroPaciente.html">Voltar</a>
	</form>
</body>
</html>