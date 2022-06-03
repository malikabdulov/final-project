package hibernate.service;

import hibernate.dao.OperationsEntityDao;
import hibernate.dao.WalletsEntityDao;
import hibernate.entity.OperationsEntity;
import hibernate.entity.WalletsEntity;

import java.sql.Timestamp;
import java.util.Date;

public class WalletsEntityService {

    private static WalletsEntityDao walletsEntityDao;
    private static OperationsEntityDao operationsEntityDao;

    public WalletsEntityService() {
        walletsEntityDao = new WalletsEntityDao();
        operationsEntityDao = new OperationsEntityDao();
    }

    public void update(WalletsEntity entity) {
        walletsEntityDao.openCurrentSessionWithTransaction();
        walletsEntityDao.update(entity);
        walletsEntityDao.closeCurrentSessionWithTransaction();
    }

    public void update(WalletsEntity walletsEntity, OperationsEntity operationsEntity) {
        walletsEntityDao.openCurrentSessionWithTransaction();
        operationsEntityDao.setCurrentSession(walletsEntityDao.getCurrentSession());
        operationsEntityDao.persist(operationsEntity);
        walletsEntityDao.update(walletsEntity);
        walletsEntityDao.closeCurrentSessionWithTransaction();
    }

    public void update(WalletsEntity walletsEntity1, OperationsEntity operationsEntity1, WalletsEntity walletsEntity2, OperationsEntity operationsEntity2) {
        walletsEntityDao.openCurrentSessionWithTransaction();
        operationsEntityDao.setCurrentSession(walletsEntityDao.getCurrentSession());
        operationsEntityDao.persist(operationsEntity1);
        walletsEntityDao.update(walletsEntity1);
        operationsEntityDao.persist(operationsEntity2);
        walletsEntityDao.update(walletsEntity2);
        walletsEntityDao.closeCurrentSessionWithTransaction();
    }

    public WalletsEntity findById(String id) {
        walletsEntityDao.openCurrentSession();
        WalletsEntity walletsEntity = walletsEntityDao.findById(id);
        walletsEntityDao.closeCurrentSession();
        return walletsEntity;
    }

    public void increaseBalance(WalletsEntity walletsEntity, Long delta) {
        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setAmount(delta);
        operationsEntity.setType_id(1);
        operationsEntity.setCreated_at(new Timestamp(new Date().getTime()));
        operationsEntity.setWallet_id(walletsEntity.getId());
        walletsEntity.increaseBalance(delta);
        this.update(walletsEntity, operationsEntity);
    }

    public void decreaseBalance(WalletsEntity walletsEntity, Long delta) {
        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setAmount(delta);
        operationsEntity.setType_id(2);
        operationsEntity.setCreated_at(new Timestamp(new Date().getTime()));
        operationsEntity.setWallet_id(walletsEntity.getId());
        walletsEntity.decreaseBalance(delta);
        this.update(walletsEntity, operationsEntity);
    }

    public void transferMoney(WalletsEntity sender, WalletsEntity recipient, Long delta) {
        OperationsEntity operationsEntitySender = new OperationsEntity();
        operationsEntitySender.setAmount(delta);
        operationsEntitySender.setType_id(3);
        operationsEntitySender.setCreated_at(new Timestamp(new Date().getTime()));
        operationsEntitySender.setWallet_id(sender.getId());
        sender.decreaseBalance(delta);

        OperationsEntity operationsEntityReceiver = new OperationsEntity();
        operationsEntityReceiver.setAmount(delta);
        operationsEntityReceiver.setType_id(4);
        operationsEntityReceiver.setCreated_at(new Timestamp(new Date().getTime()));
        operationsEntityReceiver.setWallet_id(recipient.getId());
        recipient.increaseBalance(delta);
        this.update(sender, operationsEntitySender, recipient, operationsEntityReceiver);
    }
}