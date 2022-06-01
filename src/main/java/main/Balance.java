package main;

import hibernate.dao.OperationsEntityDao;
import hibernate.entity.OperationsEntity;
import hibernate.entity.WalletsEntity;
import hibernate.service.WalletsEntityService;

import java.util.List;

public final class Balance {
    WalletsEntityService walletsEntityService = new WalletsEntityService();

    public Long getBalance(String wallet_id) {
        WalletsEntity walletsEntity = walletsEntityService.findById(wallet_id);
        if (walletsEntity != null) {
            return walletsEntity.getBalance();
        } else {
            return -1L;
        }
    }

    public Long putMoney(String user_id, Long amount) {
        WalletsEntity walletsEntity = walletsEntityService.findById(user_id);
        if (walletsEntity != null) {
            walletsEntityService.increaseBalance(walletsEntity, amount);
            return 1L;
        } else {
            return 0L;
        }
    }

    public Long takeMoney(String user_id, Long amount) {
        WalletsEntity walletsEntity = walletsEntityService.findById(user_id);
        if (walletsEntity != null) {
            if (walletsEntity.getBalance() >= amount) {
                walletsEntityService.decreaseBalance(walletsEntity, amount);
                return 1L;
            } else {
                return 0L;
            }
        } else {
            return -1L;
        }
    }

    public StringBuilder getOperations(String walletId, String fromDate, String toDate) {
        StringBuilder response = new StringBuilder();
        List<OperationsEntity> operations = new OperationsEntityDao().findByWalletId(walletId, fromDate, toDate);
        for (OperationsEntity operation : operations) {
            response.append("Date: ").append(operation.getCreated_at())
                    .append(", Type: ").append(operation.getType_id())
                    .append(", Amount: ").append(operation.getAmount())
                    .append(System.lineSeparator());
        }
        return response;
    }
}
