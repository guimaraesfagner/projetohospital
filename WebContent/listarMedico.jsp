<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="java.util.ArrayList" %>
<%@	page import="java.util.List" %>
<%@	page import="model.Medico" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Médicos</title>
</head>
<body>
	<h1>Cadastro de Médicos</h1>
	<h3>Listando Médicos Cadastrados</h3>
	<%
	Medico m;
	List<Medico> listamedico;

	listamedico = (List<Medico>) request.getAttribute("LISTA_TEMP_MEDICO");
	if (listamedico == null || listamedico.size() == 0) {
	%>
		<p>Não há Médicos Cadastrados.</p>
	<% } else { %>
		<table border="1">
			<td>Nome Médico</td>
			<td>Telefone</td>
			<td>Especialidade</td>
			<td>&nbsp;</td>
			<% for (int i = 0; i < listamedico.size(); i++) { %>
			<tr>
				<td><%= listamedico.get(i).getnomeMedico() %></td>
				<td><%= listamedico.get(i).getTelefone() %></td>
				<td><%= listamedico.get(i).getEspecialidade() %></td>
				<td><a href="ManagerMedico?metodo=remover&nomeMedico=<%= listamedico.get(i).getnomeMedico() %>">Remover</a></td>
			</tr>
			<% } %>
		</table>
	<% } %>
	<a href="cadastroMedico.html">Voltar</a>
</body>
</html>