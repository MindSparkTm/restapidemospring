package com.restservice.service;

import com.restservice.model.TotalWithdrawl;
import com.restservice.model.TotalWithdrawlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("TotalWithdrawlService")
public class TotalWithdrawlServiceImpl  implements TotalWithdrawlService{

    @Autowired
    private TotalWithdrawlRepository totalWithdrawlRepository;
    @Override
    public List<TotalWithdrawl> getlatestrecords() {

       return totalWithdrawlRepository.getlatestrecords();
    }

    @Override
    public void insertdata(String accountnumber, double amount, Timestamp timestamp) {
       totalWithdrawlRepository.insertdata(accountnumber,amount,timestamp);
    }

    @Override
    public void updatedata(double totaldeposit, String accountnumber) {
          totalWithdrawlRepository.updatebalance(totaldeposit,accountnumber);
    }
}
