package hibernate.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wallets", schema = "bank_api", catalog = "postgres")
public class WalletsEntity {
    private Integer id;
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

        WalletsEntity that = (WalletsEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(balance, that.balance)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
