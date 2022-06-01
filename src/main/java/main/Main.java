package main;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
        System.out.println("getBalance " + balance.getBalance("1").toString());
        System.out.println("putMoney " + balance.putMoney("1", 200L).toString());
        System.out.println("takeMoney " + balance.takeMoney("1", 200L).toString());
        System.out.println("getOperationsList " + balance.getOperations("1", "2022-06-01", "2022-06-02").toString());

    }
}
