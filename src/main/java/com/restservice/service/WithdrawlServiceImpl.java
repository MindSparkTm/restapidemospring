package com.restservice.service;

import com.restservice.model.AccountWithdrawl;
import com.restservice.model.AmountdepositRepository;
import com.restservice.model.WithdrawlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("WithdrawlService")
public class WithdrawlServiceImpl implements  WithdrawlService {

    @Autowired
    private WithdrawlRepository withdrawlRepository;


    @Override
    public List<AccountWithdrawl> checkflag(String accountnumber) {
        return null;
    }

    @Override
    public List<AccountWithdrawl> getlatestrecords() {
        return withdrawlRepository.getlatestwithdrawlrecords();
    }

    @Override
    public void insertdata(String accountnumber, double amount, Timestamp timestamp, long flag) {
        withdrawlRepository.insertdata(accountnumber,amount,timestamp,flag);

    }


}
