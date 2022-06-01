package json;

public class PutMoneyJson {
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
        return "PutMoneyJson{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
