<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="java.util.ArrayList" %>
<%@	page import="java.util.List" %>
<%@	page import="model.Paciente" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Pacientes</title>
</head>
<body>
	<h1>Cadastro de Pacientes</h1>
	<h3>Listando Pacientes Cadastrados</h3>
	<%
	List<Paciente> listagem;

	listagem = (List<Paciente>) request.getAttribute("LISTA_TEMP_PACIENTE");
	if (listagem == null || listagem.size() == 0) {
	%>
		<p>Não há pacientes registrados.</p>
	<% } else { %>
		<table border="1">
			<td>Nome</td>
			<td>Idade</td>
			<td>Sexo</td>
			<td>Lazer</td>
			<td>Escolaridade</td>
			<td>&nbsp;</td>
			<% for (int i = 0; i < listagem.size(); i++) { %>
			<tr>
				<td><%= listagem.get(i).getNome() %></td>
				<td><%= listagem.get(i).getIdade() %></td>
				<td><%= listagem.get(i).getSexo() %></td>
				<td><%= listagem.get(i).getLazer().getDescricao() %></td>
				<td><%= listagem.get(i).getEscolaridade().getDescricao() %></td>
				<td><a href="ManagerPaciente?metodo=RemoverPaciente&id=<%= listagem.get(i).getId() %>">Remover</a></td>
				<td><a href="ManagerPaciente?metodo=PreparaAlterarPaciente&id=<%= listagem.get(i).getId() %>">Alterar</a></td>
			</tr>
			<% } %>
		</table>
	<% } %>
	<a href="menu.html">Voltar</a>
</body>
</html>