package com.example.model;

import com.restservice.model.AccountWithdrawl;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountwithdrawlRepository extends CrudRepository<AccountWithdrawl, Long> {
    @Modifying
    @Transactional
    @Query("SELECT t FROM AccountWithdrawl t WHERE t.accountnumber= ?1")
    public List<AccountWithdrawl> getAmountWithdrawl(String accountnumber);








}


