import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

    public Money() {
        this.amount = BigDecimal.ZERO;
    }

    public Money(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount).doubleValue());
    }

    public Money minus(Money other) {
        return new Money(this.amount.subtract(other.amount).doubleValue());
    }

    public Money times(int quantity) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(quantity)).doubleValue());
    }

    public BigDecimal getAmount() {
        return amount;
    }
}