package money;

import java.util.Objects;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount,"USD");
    }

    public static Money franc(int amount) {
        return new Money(amount,"CHF");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        Money money = (Money) o;
        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public  String currency(){return currency;}

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

}
