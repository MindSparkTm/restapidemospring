package com.restservice.service;

import com.restservice.model.AccountDeposit;
import com.restservice.model.AccountbalanceRepository;
import com.restservice.model.AmountdepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("AccountDepositService")
public class AccountDepositServiceImpl implements AccountDepositService {

    @Autowired
    private AmountdepositRepository depositrepository;
    @Override
    public List<AccountDeposit> checkflag(String accountnumber) {
        return depositrepository.checkflag(accountnumber);
    }



    @Override
    public List<AccountDeposit> getlatestrecords() {
       return depositrepository.getlatestrecords();
    }

    @Override
    public void insertdata(String accountnumber, double amount, Timestamp timestamp, long flag) {
        depositrepository.insertdata(accountnumber,amount,timestamp,flag);
    }
}
