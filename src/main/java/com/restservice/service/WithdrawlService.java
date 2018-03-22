package com.restservice.service;

import com.restservice.model.AccountDeposit;
import com.restservice.model.AccountWithdrawl;

import java.util.List;


public interface WithdrawlService {
    public List<AccountWithdrawl> checkflag(String accountnumber);
    public List <AccountWithdrawl> getlatestrecords();
    public void insertdata(String accountnumber,double amount,java.sql.Timestamp timestamp,long flag);

}
