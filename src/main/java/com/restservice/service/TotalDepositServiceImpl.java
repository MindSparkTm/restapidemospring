package com.restservice.service;

import com.restservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service("TotalDepositService")
public class TotalDepositServiceImpl implements TotalDepositService {
    @Autowired
    private TotalDepositRepository totalDepositRepository;

    @Override
    public List<TotalDeposit> getlatestrecords() {
        return totalDepositRepository.getlatestrecords();
    }

    @Override
    public void insertdata(String accountnumber, double amount, Timestamp timestamp) {
          totalDepositRepository.insertdata(accountnumber,amount,timestamp);
    }

    @Override
    public void updatedata(double totaldeposit,String accountnumber) {
        totalDepositRepository.updatebalance(totaldeposit,accountnumber);
    }
}
