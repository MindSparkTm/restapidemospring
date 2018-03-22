package com.restservice.model;


import javax.persistence.*;

@Entity
@Table(name = "tbl_totalwithdrawl")
public class TotalWithdrawl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "totalwithdrawl")
    private double totalwithdrawl;

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


    public double getTotalwithdrawl() {
        return totalwithdrawl;
    }

    public void setTotalwithdrawl(double totalwithdrawl) {
        this.totalwithdrawl = totalwithdrawl;
    }


    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
