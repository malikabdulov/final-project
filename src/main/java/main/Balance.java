package main;

import hibernate.entity.BalanceEntity;
import hibernate.service.BalanceEntityService;

public class Balance {
    BalanceEntityService balanceEntityService = null;

    public Balance() {
        this.balanceEntityService = new BalanceEntityService();
    }

    public Long getBalance(String user_id) {
        BalanceEntity balanceEntity = balanceEntityService.findById(user_id);
        if (balanceEntity != null) {
            return balanceEntity.getBalance();
        } else {
            return -1L;
        }
    }

    public Long putMoney(String user_id, Long amount) {
        BalanceEntity balanceEntity = balanceEntityService.findById(user_id);
        if (balanceEntity != null) {
            balanceEntityService.increaseBalance(balanceEntity, amount);
            return 1L;
        } else {
            return 0L;
        }
    }

    public Long takeMoney(String user_id, Long amount) {
        BalanceEntity balanceEntity = balanceEntityService.findById(user_id);
        if (balanceEntity != null) {
            if (balanceEntity.getBalance() >= amount){
                balanceEntityService.decreaseBalance(balanceEntity, amount);
                return 1L;
            } else {
                return 0L;
            }
        } else {
            return -1L;
        }
    }
}
