package json;

public class GetBalanceJson {
    private Long balance;
    private String message;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GetBalanceJson{" +
                "balance=" + balance +
                ", message='" + message + '\'' +
                '}';
    }
}
