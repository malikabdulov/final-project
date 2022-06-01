package hibernate.dao;

import hibernate.entity.OperationsEntity;
import hibernate.entity.WalletsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class OperationsEntityDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public OperationsEntityDao() {
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

    public void persist(OperationsEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void update(OperationsEntity entity) {
        getCurrentSession().update(entity);
    }

    public OperationsEntity findById(String id) {
        OperationsEntity operationsEntity = (OperationsEntity) getCurrentSession().get(OperationsEntity.class, id);
        return operationsEntity;
    }

    public void delete(OperationsEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<OperationsEntity> findAll() {
        this.openCurrentSession();
        List<OperationsEntity> operations = (List<OperationsEntity>) getCurrentSession().createQuery("from OperationsEntity").list();
        this.closeCurrentSession();
        return operations;
    }

    @SuppressWarnings("unchecked")
    public List<OperationsEntity> findByWalletId(String walletId, String fromDate, String toDate) {
        this.openCurrentSession();
        String hql = "from OperationsEntity where wallet_id = :wallet_id ";
        if (fromDate != null){
            hql = hql + "and created_at > '" + fromDate + "' ";
        }
        if (toDate != null){
            hql = hql + "and created_at < '" + toDate + "' ";
        }

        List<OperationsEntity> operations = (List<OperationsEntity>) getCurrentSession().createQuery(hql).setParameter("wallet_id", walletId).list();
        this.closeCurrentSession();
        return operations;
    }

    @SuppressWarnings("unchecked")
    public List<OperationsEntity> findByWalletId(String walletId) {
        this.openCurrentSession();
        String hql = "from OperationsEntity where wallet_id = :wallet_id";

        List<OperationsEntity> operations = (List<OperationsEntity>) getCurrentSession().createQuery(hql).setParameter("wallet_id", walletId).list();
        this.closeCurrentSession();
        return operations;
    }

    public void deleteAll() {
        List<OperationsEntity> entityList = findAll();
        for (OperationsEntity entity : entityList) {
            delete(entity);
        }
    }
}
