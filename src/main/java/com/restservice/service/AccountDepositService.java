package com.restservice.service;

import com.restservice.model.AccountBalance;
import com.restservice.model.AccountDeposit;

import java.util.List;

public interface AccountDepositService  {
    public List<AccountDeposit> checkflag(String accountnumber);
    public List <AccountDeposit> getlatestrecords();
    public void insertdata(String accountnumber,double amount,java.sql.Timestamp timestamp,long flag);

}
