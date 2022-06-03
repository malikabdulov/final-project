package json;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GetOperationListJson {
    private List<Operation> operations = new ArrayList<Operation>();

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public static class Operation {


        private String date;
        private String operationType;
        private Long amount;

        public String getDate() {
            return date;
        }

        public void setDate(Timestamp date) {
            this.date = date.toString();
        }

        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(int operationType) {

            switch (operationType) {
                case (1):
                    this.operationType = "Put money";
                    break;
                case (2):
                    this.operationType = "Take money";
                    break;
                case (3):
                    this.operationType = "Transfer out";
                    break;
                case (4):
                    this.operationType = "Transfer in";
                    break;
            }
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "date='" + date + '\'' +
                    ", operationType='" + operationType + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetOperationListJson{" +
                "operations=" + operations +
                '}';
    }
}
