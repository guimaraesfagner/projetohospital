package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

private static final SessionFactory sessionFactory;

   
    static {
        try {
            /* 
              Carrrega as configurações ( tando do arquivo xml quanto as 
              anotações feitas nas classes Entity) e
              cria um objeto Factory para manipular sessão
            */
            sessionFactory = new AnnotationConfiguration().
                    configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
    	/*
    	  obtem um sessão, o método requisita uma sessão ao manager session
    	  se uma sessão não existir ele cria, e guarda a referencia para que
    	  cada nova requisição possa receber a mesma sessão
    	*/
        return sessionFactory.getCurrentSession();
    }
}

