package com.restservice.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_withdrawl")
public class AccountWithdrawl {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "withdrawlamount")
    private double withdrawlamount;

    @Column(name = "timestamp")
    private java.sql.Timestamp  timestamp;

    @Column(name = "flag")
    private long flag;


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


    public double getWithdrawlamount() {
        return withdrawlamount;
    }

    public void setWithdrawlamount(long withdrawlamount) {
        this.withdrawlamount = withdrawlamount;
    }


    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }

}
