package hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "operations", schema = "bank_api", catalog = "postgres")
public class OperationsEntity {
    private Integer id;
    private Integer wallet_id;
    private Integer type_id;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    private Long amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wallet_id", nullable = true)
    public Integer getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Integer wallet_id) {
        this.wallet_id = wallet_id;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }


    @Basic
    @Column(name = "amount", nullable = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationsEntity that = (OperationsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OperationsEntity{" +
                "id=" + id +
                ", wallet_id=" + wallet_id +
                ", type_id=" + type_id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }
}
