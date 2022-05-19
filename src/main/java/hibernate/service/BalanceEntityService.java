package hibernate.service;

import java.util.List;

import hibernate.dao.BalanceEntityDao;
import hibernate.entity.BalanceEntity;

public class BalanceEntityService {

    private static BalanceEntityDao balanceEntityDao;

    public BalanceEntityService() {
        balanceEntityDao = new BalanceEntityDao();
    }

    public void persist(BalanceEntity entity) {
        balanceEntityDao.openCurrentSessionwithTransaction();
        balanceEntityDao.persist(entity);
        balanceEntityDao.closeCurrentSessionwithTransaction();
    }

    public void update(BalanceEntity entity) {
        balanceEntityDao.openCurrentSessionwithTransaction();
        balanceEntityDao.update(entity);
        balanceEntityDao.closeCurrentSessionwithTransaction();
    }

    public BalanceEntity findById(String id) {
        balanceEntityDao.openCurrentSession();
        BalanceEntity balanceEntity = balanceEntityDao.findById(id);
        balanceEntityDao.closeCurrentSession();
        return balanceEntity;
    }

    public void increaseBalance(BalanceEntity balanceEntity, Long delta) {
        balanceEntity.increaseBalance(delta);
        this.update(balanceEntity);
    }

    public void decreaseBalance(BalanceEntity balanceEntity, Long delta) {
        balanceEntity.decreaseBalance(delta);
        this.update(balanceEntity);
    }
}