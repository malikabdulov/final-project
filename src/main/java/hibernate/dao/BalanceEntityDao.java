package hibernate.dao;

import java.util.List;

import hibernate.entity.BalanceEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BalanceEntityDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public BalanceEntityDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(BalanceEntity.class)
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

    public void persist(BalanceEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void update(BalanceEntity entity) {
        getCurrentSession().update(entity);
    }

    public BalanceEntity findById(String id) {
        BalanceEntity balanceEntity = (BalanceEntity) getCurrentSession().get(BalanceEntity.class, id);
        return balanceEntity;
    }

    public void delete(BalanceEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<BalanceEntity> findAll() {
        List<BalanceEntity> balances = (List<BalanceEntity>) getCurrentSession().createQuery("from BalanceEntity").list();
        return balances;
    }

    public void deleteAll() {
        List<BalanceEntity> entityList = findAll();
        for (BalanceEntity entity : entityList) {
            delete(entity);
        }
    }
}
