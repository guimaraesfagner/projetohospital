<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="model.Paciente" %>
<%@	page import="java.util.List" %>
<%@	page import="model.Lazer" %>
<%@	page import="model.Escolaridade" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de Paciente</title>
</head>
<body>
	<h1>Alteração de Pacientes</h1>
	<h3>Digite os novos dados e clique em salvar</h3>
	<form action="ManagerPaciente" method="post">
	<%
	Paciente paciente;
	paciente = (Paciente) request.getAttribute("PACIENTE");
	%>
	<input type="hidden" name="id" value="<%=paciente.getId()%>" />
	<input type="hidden" name="metodo" value="AlterarPaciente" />
	
	<table border="1">
		<tr>
		
		
		
			<td>Nome</td>
			<td><input type="text" name="nome" size="30" value="<%= paciente.getNome()%>" /></td>
		</tr>
		<tr>
			<td>Idade</td>
			<td><input type="text" name="idade" size="2" value="<%= paciente.getIdade()%>"/></td>
		</tr>
		<tr>
			<td>Sexo</td>
			<td><input type="radio" name="sexo" value="M" <% if (paciente.getSexo().equals("M")) {out.print("checked");}%>/> M &nbsp; 
			    <input type="radio" name="sexo" value="F" <% if (paciente.getSexo().equals("F")) {out.print("checked");}%>/> F</td>
		</tr>
		<tr>
			<td>Lazer</td>
			<td><select name="lazer">
				<%
				List<Lazer> listagemLazer;

				listagemLazer = (List<Lazer>) request.getAttribute("LISTA_LAZER");				
				for (int i = 0; i < listagemLazer.size(); i++) { %>

					<option value="<%= listagemLazer.get(i).getId()%>" <% if (listagemLazer.get(i).getId() == paciente.getLazer().getId()) {out.print("selected");} %>><%= listagemLazer.get(i).getDescricao()%></option>
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
					
					<option value="<%= listagemEscolaridade.get(i).getId()%>" <% if (listagemEscolaridade.get(i).getId() == paciente.getEscolaridade().getId()) {out.print("selected");} %>><%= listagemEscolaridade.get(i).getDescricao()%></option>
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