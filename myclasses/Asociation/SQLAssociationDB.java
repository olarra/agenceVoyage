package association;

import java.util.List;
import java.io.Serializable;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import association.Association;


public class SQLAssociationDB {

    SessionFactory sessionFactory;

    public SQLAssociationDB (SessionFactory sessionFactory) {

      this.sessionFactory = sessionFactory;

    }

    public Association createAssociation (int idUtilisateur, int idHebergement)
    {
        Session hibernateSession=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=hibernateSession.beginTransaction();
        Serializable id=hibernateSession.save(new Association(idUtilisateur,idHebergement));
        Association res=(Association)hibernateSession.get(Association.class,id);
        transaction.commit();
        hibernateSession.close();
        return res;
      }


    public List<Association> loadAssociations () {
      Session hibernateSession=this.sessionFactory.openSession();
      Transaction transaction=null;
      transaction=hibernateSession.beginTransaction();
      Query query=hibernateSession.createQuery("from Association");
      List<Association> allAssociations=query.list();
      hibernateSession.close();
      return allAssociations;
  }

}
