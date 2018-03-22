package com.restservice.service;

import com.restservice.model.TotalDeposit;
import com.restservice.model.TotalWithdrawl;

import java.util.List;

public interface TotalWithdrawlService  {

    public List<TotalWithdrawl> getlatestrecords();
    public void insertdata(String accountnumber,double amount,java.sql.Timestamp timestamp);

    public void updatedata(double totaldeposit,String accountnumber);
}
