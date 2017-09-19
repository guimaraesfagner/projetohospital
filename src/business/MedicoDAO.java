package business;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import util.HibernateUtil;
import model.Escolaridade;
import model.Medico;
import model.Paciente;

public class MedicoDAO {
	private MedicoDAO() { }
	
	private static MedicoDAO instance;
	
	public static MedicoDAO getInstance(){
		if (instance == null)
			instance = new MedicoDAO();
		return instance;
	}
	
	public Medico getMedico(String id) {		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		Medico medico = (Medico) session.get(Medico.class, id);		
		tr.commit();
		return medico;
	}
	
	public void salvar(Medico medico){
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(medico);
		tr.commit();
		return;
	}

	public List<Medico> listarMedico() {
		List<Medico> listaMedico;
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Medico.class);
		listaMedico = cr.list();
		tr.commit();
		return listaMedico;
	}
	
	public void remover(String id){
		Medico medico = getMedico(id);
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(medico);
		tr.commit();
		return;
	}
	
	public List<Medico> listar(String nomeMedico) {
		List<Medico> lista;
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Medico.class);
		cr.add(Expression.ilike("nomeMedico", nomeMedico));
		cr.addOrder(Order.asc("nomeMedico"));
		lista = cr.list();
		tr.commit();
		return lista;
	}
}


