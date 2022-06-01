package hibernate.dao;

import java.util.List;

import hibernate.entity.OperationsEntity;
import hibernate.entity.WalletsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WalletsEntityDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public WalletsEntityDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(WalletsEntity.class)
                .addAnnotatedClass(OperationsEntity.class)
                .configure()
                .buildSessionFactory();
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(WalletsEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void update(WalletsEntity entity) {
        getCurrentSession().update(entity);
    }

    public WalletsEntity findById(String id) {
        WalletsEntity walletsEntity = (WalletsEntity) getCurrentSession().get(WalletsEntity.class, id);
        return walletsEntity;
    }

    public void delete(WalletsEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<WalletsEntity> findAll() {
        List<WalletsEntity> balances = (List<WalletsEntity>) getCurrentSession().createQuery("from WalletsEntity").list();
        return balances;
    }

    public void deleteAll() {
        List<WalletsEntity> entityList = findAll();
        for (WalletsEntity entity : entityList) {
            delete(entity);
        }
    }
}
