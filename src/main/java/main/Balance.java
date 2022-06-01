package main;

import hibernate.dao.OperationsEntityDao;
import hibernate.entity.OperationsEntity;
import hibernate.entity.WalletsEntity;
import hibernate.service.WalletsEntityService;
import json.GetBalanceJson;
import json.GetOperationListJson;
import json.PutMoneyJson;
import json.TakeMoneyJson;

import java.sql.Timestamp;
import java.util.List;

public final class Balance {
    WalletsEntityService walletsEntityService = new WalletsEntityService();

    public GetBalanceJson getBalance(String wallet_id) {
        WalletsEntity walletsEntity = walletsEntityService.findById(wallet_id);
        GetBalanceJson response = new GetBalanceJson();
        if (walletsEntity != null) {
            response.setBalance(walletsEntity.getBalance());
            response.setMessage("OK");
        } else {
            response.setBalance(-1L);
            response.setMessage("User not found");
        }
        return response;
    }

    public PutMoneyJson putMoney(String user_id, Long amount) {
        WalletsEntity walletsEntity = walletsEntityService.findById(user_id);
        PutMoneyJson response = new PutMoneyJson();
        if (walletsEntity != null) {
            walletsEntityService.increaseBalance(walletsEntity, amount);
            response.setStatus(1);
            response.setMessage("OK");
        } else {
            response.setStatus(0);
            response.setMessage("User not found");
        }
        return response;

    }

    public TakeMoneyJson takeMoney(String user_id, Long amount) {
        WalletsEntity walletsEntity = walletsEntityService.findById(user_id);
        TakeMoneyJson response = new TakeMoneyJson();
        if (walletsEntity != null) {
            if (walletsEntity.getBalance() >= amount) {
                walletsEntityService.decreaseBalance(walletsEntity, amount);
                response.setStatus(1);
                response.setMessage("OK");
            } else {
                response.setStatus(0);
                response.setMessage("Not enough balance");
            }
        } else {
            response.setStatus(0);
            response.setMessage("User not found");
        }
        return response;
    }

    public GetOperationListJson getOperations(String walletId, String fromDate, String toDate) {
        GetOperationListJson response = new GetOperationListJson();
        List<OperationsEntity> operations = new OperationsEntityDao().findByWalletId(walletId, fromDate, toDate);
        for (OperationsEntity operation: operations){
            Timestamp date = operation.getCreated_at();
            int type = operation.getType_id();
            Long amount = operation.getAmount();
            GetOperationListJson.Operation operationJson = new GetOperationListJson.Operation();
            operationJson.setDate(date);
            operationJson.setOperationType(type);
            operationJson.setAmount(amount);
            response.getOperations().add(operationJson);
        }
        return response;
    }
}
