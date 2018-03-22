package com.restservice.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_accountbalance")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "accountnumber")
    private String accountnumber;
    @Column(name = "balance")
    private double balance;
    @Column(name = "timestamp")
    private java.sql.Timestamp timestamp;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Accountbalance{" +
                "Accountnumber=" + accountnumber +
                ", Balance='" + balance + '\'' +
                ", DateTime='" + timestamp + '\'' +
                '}';
    }
}
