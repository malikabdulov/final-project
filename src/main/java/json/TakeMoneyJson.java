package json;

public class TakeMoneyJson {
    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TakeMoneyJson{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
