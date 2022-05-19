package hibernate.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "balance", schema = "bank_api", catalog = "postgres")
public class BalanceEntity {
    private Integer id;
    private Integer userId;
    private Long balance;

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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "balance", nullable = true)
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void increaseBalance(Long delta) {
        this.setBalance(this.getBalance() + delta);
    }

    public void decreaseBalance(Long delta) {
        this.setBalance(this.getBalance() - delta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceEntity that = (BalanceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, balance);
    }
}
