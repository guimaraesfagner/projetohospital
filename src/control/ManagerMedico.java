package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medico;
import business.MedicoDAO;

public class ManagerMedico extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public ManagerMedico() {
		super();
	}
	
	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Medico medico = new Medico();
		medico.setnomeMedico(request.getParameter("nomeMedico"));
		medico.settelefone(request.getParameter("telefone"));
		medico.setEspecialidade(request.getParameter("especialidade"));
		MedicoDAO.getInstance().salvar(medico);
		response.sendRedirect("cadastroMedico.html");
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> listaMedico = MedicoDAO.getInstance().listarMedico();
		if(listaMedico != null)
			request.setAttribute("LISTA_TEMP_MEDICO", listaMedico);
		RequestDispatcher rd = request.getRequestDispatcher("listarMedico.jsp");
		rd.forward(request, response);
	}
	
	private void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("nomeMedico");
		if (id == null || id.equals(""))
			response.sendRedirect("listarMedico.jsp");
		MedicoDAO.getInstance().remover(id);
		listar(request, response);
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeMedico = request.getParameter("indice");
		List<Medico> lista = MedicoDAO.getInstance().listar(nomeMedico);
		if (lista != null) 
			request.setAttribute("LISTA_TEMP_MEDICO", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listarMedico.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		if (metodo.equals("incluir")) incluir(request, response);
		else if (metodo.equals("listar")) listar(request, response);
		else if (metodo.equals("remover")) remover(request, response);
		else if (metodo.equals("buscar")) buscar(request, response);
	}   	  	    
}