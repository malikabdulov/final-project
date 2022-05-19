package main;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
        System.out.println("getBalance " + balance.getBalance("10"));
        System.out.println("putMoney " + balance.putMoney("10", 5000L));
        System.out.println("takeMoney " + balance.takeMoney("10", 1200L));
    }
}
