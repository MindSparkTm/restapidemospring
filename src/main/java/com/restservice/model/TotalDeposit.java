package com.restservice.model;


import javax.persistence.*;

@Entity
@Table(name = "tbl_totaldeposit")
public class TotalDeposit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "accountnumber")
    private String accountnumber;


    @Column(name = "totaldeposit")
    private double totaldeposit;

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


    public double getTotaldeposit() {
        return totaldeposit;
    }

    public void setTotaldeposit(double totaldeposit) {
        this.totaldeposit = totaldeposit;
    }


    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}

