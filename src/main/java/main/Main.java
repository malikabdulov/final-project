package main;

import hibernate.entity.OperationsEntity;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
//        System.out.println("getBalance " + balance.getBalance("1"));
//        System.out.println("putMoney " + balance.putMoney("1", 5000L));
//        System.out.println("takeMoney " + balance.takeMoney("1", 1200L));
//        System.out.println("getBalance " + balance.getBalance("1"));
//        balance.getBalance("1");
        for (OperationsEntity operation: balance.getOperations("1")){
            System.out.println(operation.toString());
        }
    }
}
