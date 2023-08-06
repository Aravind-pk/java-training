package bank;

import java.math.BigDecimal;

public class Account {
    final int acNo;
    String acType;
    BigDecimal accBalance;

    public Account(int acNo, String acType, BigDecimal accBalance) {
        this.acNo = acNo;
        this.acType = acType;
        this.accBalance = accBalance;
    }

    public BigDecimal getAccBalance() {
        return accBalance;
    }
    public void addDebit(BigDecimal debit) {
        this.accBalance = this.accBalance.subtract(debit);
    }
    public void addCredit(BigDecimal credit) {
        this.accBalance = this.accBalance.add(credit);
    }

    @Override
    public String toString() {
        return "Account{" +
                "acNo=" + acNo +
                ", acType='" + acType + '\'' +
                ", accBalance=" + accBalance +
                '}' +"\n";
    }
}
