package com.restservice.service;

import com.restservice.model.AccountBalance;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountBalanceService {

    public List<AccountBalance> findBalanceByAccountnumber();
    public List<AccountBalance> displaybalance(String accountnumber);
    public void updatebalance(double balance,String accountnumber);



}
