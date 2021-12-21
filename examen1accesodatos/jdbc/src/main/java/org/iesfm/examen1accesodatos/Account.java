package org.iesfm.examen1accesodatos;

import java.util.Date;
import java.util.Objects;


public class Account {
    private String iban;
    private int owner_id;
    private double balance;
    private Date open_Date;

    public Account(String iban, int owner_id, double balance, Date open_Date) {
        this.iban = iban;
        this.owner_id = owner_id;
        this.balance = balance;
        this.open_Date = open_Date;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpen_Date() {
        return open_Date;
    }

    public void setOpen_Date(Date open_Date) {
        this.open_Date = open_Date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return owner_id == account.owner_id && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(open_Date, account.open_Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, owner_id, balance, open_Date);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", owner_id=" + owner_id +
                ", balance=" + balance +
                ", open_Date=" + open_Date +
                '}';
    }
}
