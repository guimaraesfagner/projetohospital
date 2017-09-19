package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Escolaridade;
import model.Lazer;
import model.Paciente;
import business.PacienteDAO;

/**
 * Servlet implementation class for Servlet: ManagerPaciente
 *
 */
 public class ManagerPaciente extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
 
	public ManagerPaciente() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		
		if(metodo.equals("listar")) {
			List<Paciente>lista =  PacienteDAO.getInstance().listar();

			// Gravar no request com o nome "LISTA_TEMP_PACIENTE"
			if( lista != null)
				request.setAttribute("LISTA_TEMP_PACIENTE", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);
			
		} else if (metodo.equals("preparaIncluir")) {
			
			List<Lazer> lista =  PacienteDAO.getInstance().listarLazer();
			List<Escolaridade> listae =  PacienteDAO.getInstance().listarEscolaridade();

			
			request.setAttribute("LISTA_LAZER", lista);
			request.setAttribute("LISTA_ESCOLARIDADE", listae);
			
			RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp");
			rd.forward(request, response);
		
		} else if (metodo.equals("IncluirPaciente")) {
			PacienteDAO pacienteDAO = PacienteDAO.getInstance();
			List<Paciente> lista;
			Paciente paciente = new Paciente();
			paciente.setNome(request.getParameter("nome"));			
			paciente.setIdade(request.getParameter("idade"));
			paciente.setSexo(request.getParameter("sexo"));
			
			int idl = Integer.parseInt(request.getParameter("lazer"));
			paciente.setLazer(PacienteDAO.getInstance().getLazer(idl));
			
			int ide = Integer.parseInt(request.getParameter("escolaridade"));
			paciente.setEscolaridade(PacienteDAO.getInstance().getEscolaridade(ide));
				
			pacienteDAO.salvar(paciente);	
			
			lista = PacienteDAO.getInstance().listar();

			// Gravar no request com o nome "LISTA_TEMP_PACIENTE"
			if( lista != null)
				request.setAttribute("LISTA_TEMP_PACIENTE", lista);
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);			
		}  else if(metodo.equals("buscaPaciente")) {
			String buscaNome = (String) request.getParameter("pac");
			
			List<Paciente> lista = PacienteDAO.getInstance().listar(buscaNome);			
			
			request.setAttribute("LISTA_TEMP_PACIENTE", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);
			
		
		} else if(metodo.equals("PreparaAlterarPaciente")) {
			
			List<Lazer> listal = PacienteDAO.getInstance().listarLazer();
			request.setAttribute("LISTA_LAZER", listal);
			
			List<Escolaridade> listae = PacienteDAO.getInstance().listarEscolaridade();
			request.setAttribute("LISTA_ESCOLARIDADE", listae);
			
			List<Paciente>pacientes = PacienteDAO.getInstance().listar();
			Paciente paciente = new Paciente();
						
			int id = Integer.parseInt(request.getParameter("id"));
				
			if( pacientes != null){
				for(Paciente item: pacientes){
					if(id == item.getId()){
						paciente = item;
						request.setAttribute("PACIENTE", paciente);
						
						RequestDispatcher rd = request.getRequestDispatcher("alterarPaciente.jsp");
						rd.forward(request, response);
				}
			}
		}
			
			
		} else if (metodo.equals("AlterarPaciente")) {
			
//			HttpSession sessao = request.getSession();
			Paciente paciente = new Paciente();
		    paciente.setId(Integer.parseInt(request.getParameter("id")));	    
			paciente.setNome(request.getParameter("nome"));			
			paciente.setIdade(request.getParameter("idade"));
			paciente.setSexo(request.getParameter("sexo"));
			
			int idl = Integer.parseInt(request.getParameter("lazer"));
			paciente.setLazer(PacienteDAO.getInstance().getLazer(idl));
			
			int ide = Integer.parseInt(request.getParameter("escolaridade"));
			paciente.setEscolaridade(PacienteDAO.getInstance().getEscolaridade(ide));
				
		
			PacienteDAO pacienteDAO = PacienteDAO.getInstance();
			pacienteDAO.alterar(paciente);
		
			List<Paciente>lista = PacienteDAO.getInstance().listar();
			 

			// Gravar no request com o nome "LISTA_TEMP_PACIENTE"
			if( lista != null)
				request.setAttribute("LISTA_TEMP_PACIENTE", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);
			
		} else if(metodo.equals("RemoverPaciente")) {	
		 
			int id = Integer.parseInt(request.getParameter("id"));
		
			PacienteDAO pacienteDAO = PacienteDAO.getInstance();
			pacienteDAO.remover(id);
		
			List<Paciente>lista =   pacienteDAO.listar();
	
			// Gravar no request com o nome "LISTA_TEMP_PACIENTE"
			if( lista != null)
				request.setAttribute("LISTA_TEMP_PACIENTE", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);
		
		}
	}
	
			
		
}   	  	    
