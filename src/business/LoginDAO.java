package business;


import java.util.List;

import model.Login;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class LoginDAO {



	public List<Login> buscarLogin() {
		List<Login> buscaLogin;
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr       = session.createCriteria(Login.class);		

		buscaLogin = cr.list();
		
		tr.commit();
		
		return buscaLogin;
	}
	
	public Login get(String nome) {		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		
		Login login  = (Login) session.get(Login.class,nome);		
		
		tr.commit();
		
		return login;
		
	}
	
}