package controller;

import json.*;
import org.springframework.web.bind.annotation.*;
import main.Balance;


@RestController
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping("/getBalance/{userId}")
    public GetBalanceJson getBalance(@PathVariable String userId) {
        return new Balance().getBalance(userId);
    }

    @GetMapping("/putMoney/{userId}/{amount}")
    public PutMoneyJson putMoney(@PathVariable String userId, @PathVariable Long amount) {
        return new Balance().putMoney(userId, amount);
    }

    @GetMapping("/takeMoney/{userId}/{amount}")
    public TakeMoneyJson takeMoney(@PathVariable String userId, @PathVariable Long amount) {
        return new Balance().takeMoney(userId, amount);
    }

    @GetMapping("/getOperationList/{userId}")
    public GetOperationListJson getOperationList(@PathVariable String userId,
                                                 @RequestParam(required = false) String fromDate,
                                                 @RequestParam(required = false) String toDate) {
        return new Balance().getOperations(userId, fromDate, toDate);
    }

    @GetMapping("/transferMoney/{senderId}/{recipientId}/{amount}")
    public TransferMoneyJson transferMoney(@PathVariable String senderId,
                                           @PathVariable String recipientId,
                                           @PathVariable Long amount) {
        return new Balance().transferMoney(senderId, recipientId, amount);
    }
}