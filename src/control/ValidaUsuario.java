package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Lazer;
import model.Login;
import business.LoginDAO;
import business.PacienteDAO;


 public class ValidaUsuario extends HttpServlet implements javax.servlet.Servlet {

	public ValidaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String usuario = request.getParameter("usu");
		  String senha = request.getParameter("pwd");
		  
		  Login login = new LoginDAO().get(usuario);
		   
		  if(login != null) {
			  if( login.getSenha().equals(senha) ) {					  
				  response.sendRedirect("menu.html"); 					  
			  }
		  }
		  
    	  PrintWriter saida = response.getWriter();
		  saida.print("<script>");
		  saida.print("alert('Não há usuarios cadastrados. Por favor Cadastrar pelo Banco de Dados');");
		  saida.print("document.location=('index.html');");
		  saida.print("</script>");
		  saida.close();	
		  
/*		  List<Login> logins = new LoginDAO().buscarLogin();		    
					  							
		 if(logins != null && !logins.isEmpty()) {		  
			 for (int i = 0; i <  logins.size();i++)   {	  
				  Login login = logins.get(i); 
				  if( login.getNome().equals(usuario) & login.getSenha().equals(senha) ) {					  
					  response.sendRedirect("menu.html"); 	
					  break;
				  } else {
					  response.sendRedirect("index.html");			       
				  }
			  }		  
			  
	   } else  {
	    	  PrintWriter saida = response.getWriter();
			  saida.print("<script>");
			  saida.print("alert('Não há usuarios cadastrados. Por favor Cadastrar pelo Banco de Dados');");
			  saida.print("document.location=('index.html');");
			  saida.print("</script>");
			  saida.close();	  
		}*/
		  
		  
	} //Fim do doPost
} //Fim da Classe
