package com.restservice.service;


import com.restservice.model.AccountBalance;
import com.restservice.model.AccountbalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountBalanceService")
public class AccountBalanceServiceImpl implements  AccountBalanceService {

    @Autowired
    private AccountbalanceRepository accountbalanceRepository;

    @Override
    public List<AccountBalance> findBalanceByAccountnumber() {


        return accountbalanceRepository.findAll();
    }

    @Override
    public List<AccountBalance> displaybalance(String accountnumber) {
        return accountbalanceRepository.displaybalance(accountnumber);
    }

    @Override
    public void updatebalance(double balance, String accountnumber) {
        accountbalanceRepository.updatebalance(balance,accountnumber);
    }
}
