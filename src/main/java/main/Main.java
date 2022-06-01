package main;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
        System.out.println("getOperationsList " + balance.getOperations("1", "2022-05-30", "2022-06-02"));
        System.out.println("getOperationsList " + balance.getOperations("1", "2022-05-30", null));
        System.out.println("getOperationsList " + balance.getOperations("1", null, "2022-06-02"));
        System.out.println("getOperationsList " + balance.getOperations("1", null, null));
    }
}
