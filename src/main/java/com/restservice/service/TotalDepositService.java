package com.restservice.service;


import com.restservice.model.AccountDeposit;
import com.restservice.model.AccountWithdrawl;
import com.restservice.model.TotalDeposit;
import com.restservice.model.TotalWithdrawl;

import java.util.List;

public interface TotalDepositService {

    public List <TotalDeposit> getlatestrecords();
    public void insertdata(String accountnumber,double amount,java.sql.Timestamp timestamp);

    public void updatedata(double totaldeposit,String accountnumber);
}
