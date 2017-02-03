package association;

import java.util.List;
import java.io.Serializable;
import association.SQLAssociationDB;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AssociationDBHandler {

  private static SQLAssociationDB db;
  private static SessionFactory sessionFactory;

//Constructeur
  public static SQLAssociationDB getDb ()
   {
    if (AssociationDBHandler.db==null) {
        AssociationDBHandler.initialize();
    }
    return AssociationDBHandler.db;
  }

// Methode d'initialiation

    private static void initialize () {
      Configuration configuration = null;
      ServiceRegistry registry = null;
      try {
          configuration = new Configuration().configure();
          registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
      } catch (Throwable e) {
          throw e;
      }
      AssociationDBHandler.sessionFactory=configuration.buildSessionFactory(registry);

      AssociationDBHandler.db = new SQLAssociationDB(AssociationDBHandler.sessionFactory);

    }


}
