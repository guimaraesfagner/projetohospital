package business;

import java.util.List;

import model.Escolaridade;
import model.Lazer;
import model.Paciente;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import util.HibernateUtil;

public class PacienteDAO {
	private PacienteDAO(){}
	
	private static PacienteDAO instance;
	
	public static PacienteDAO getInstance(){
		if (instance == null)
			instance = new PacienteDAO();
		return instance;
	}
	
	public void salvar(Paciente paciente){
			Session session = HibernateUtil.getSession();
			Transaction tr = session.beginTransaction();
			
			session.saveOrUpdate(paciente);

			tr.commit();
			
			return;
	}
	
	public void alterar(Paciente paciente){
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		session.update(paciente);

		tr.commit();
		
		return;
}
	
	public  void remover(int id){
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		
		session.delete(session.get(Paciente.class, id));

		tr.commit();
		
		return ;
}
	public List<Paciente> listar() {
		List<Paciente> lista;
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr = session.createCriteria(Paciente.class);
		cr.addOrder(Order.asc("nome"));
		lista = cr.list();
		
		tr.commit();
		
		return lista;
	}
	
	public List<Paciente> listar(String nome) {
		List<Paciente> lista;
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr = session.createCriteria(Paciente.class);
		
		cr.add(Expression.ilike("nome", nome));
		
		cr.addOrder(Order.asc("nome"));
		lista = cr.list();
		
		tr.commit();
		
		return lista;
	}
	
	public List<Lazer> listarLazer() {
		List<Lazer> lista;
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr       = session.createCriteria(Lazer.class);
		
		lista = cr.list();
		
		tr.commit();
		
		return lista;
	}
	
	public Lazer getLazer(int id) {		
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Lazer item = (Lazer)session.get(Lazer.class,id);		
		
		tr.commit();
		
		return item;
	}
	
	public List<Escolaridade> listarEscolaridade(){
		List<Escolaridade> lista;
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr = session.createCriteria(Escolaridade.class);
		
		lista = cr.list();
		
		
		return lista;		
		
	}
	
public Escolaridade getEscolaridade(int id) {		
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Escolaridade item = (Escolaridade)session.get(Escolaridade.class,id);		
		
		tr.commit();
		
		return item;
}
}