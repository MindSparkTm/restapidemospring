package com.restservice.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface WithdrawlRepository extends CrudRepository<AccountWithdrawl, Long> {

    @Modifying
    @Transactional
    @Query("SELECT t FROM AccountWithdrawl t WHERE t.accountnumber= ?1")
    public List<AccountWithdrawl> checkflag(String accountnumber);

    @Modifying
    @Transactional
    @Query("select t from AccountWithdrawl t order by t.id asc")
    public List <AccountWithdrawl> getlatestwithdrawlrecords();


    @Modifying
    @Query(value = "insert into tbl_withdrawl (accountnumber,withdrawlamount,timestamp,flag) VALUES (:accountnumber,:withdrawlamount,:timestamp,:flag)", nativeQuery = true)
    @Transactional
    void insertdata(@Param("accountnumber") String accountnumber, @Param("withdrawlamount") double withdrawlamount, @Param("timestamp") java.sql.Timestamp  timestamp, @Param("flag")long flag);

}
