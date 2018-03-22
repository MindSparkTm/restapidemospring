package com.restservice.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountbalanceRepository extends JpaRepository<AccountBalance, Long> {


    @Modifying
    @Transactional
    @Query("SELECT t FROM AccountBalance t WHERE t.accountnumber= ?1")
    public List<AccountBalance> displaybalance(String accountnumber);


    @Modifying
    @Transactional
    @Query("Update AccountBalance t SET t.balance=:balance WHERE t.accountnumber=:accountnumber")
    public void updatebalance(@Param("balance") double balance, @Param("accountnumber") String accountnumber);




}
