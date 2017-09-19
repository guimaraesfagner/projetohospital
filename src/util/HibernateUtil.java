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
              Carrrega as configura��es ( tando do arquivo xml quanto as 
              anota��es feitas nas classes Entity) e
              cria um objeto Factory para manipular sess�o
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
    	  obtem um sess�o, o m�todo requisita uma sess�o ao manager session
    	  se uma sess�o n�o existir ele cria, e guarda a referencia para que
    	  cada nova requisi��o possa receber a mesma sess�o
    	*/
        return sessionFactory.getCurrentSession();
    }
}

