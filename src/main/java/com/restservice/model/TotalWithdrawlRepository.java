package com.restservice.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TotalWithdrawlRepository extends CrudRepository<TotalWithdrawl, Long> {

    @Modifying
    @Transactional
    @Query("select t from TotalWithdrawl t order by t.id asc")
    public List<TotalWithdrawl> getlatestrecords();

    @Modifying
    @Transactional
    @Query("Update TotalWithdrawl t SET t.totalwithdrawl=:totalwithdrawl WHERE t.accountnumber=:accountnumber")
    public void updatebalance(@Param("totalwithdrawl") double totalwithdrawl, @Param("accountnumber") String accountnumber);


    @Modifying
    @Query(value = "insert into tbl_totalwithdrawl (accountnumber,totalwithdrawl,timestamp) VALUES (:accountnumber,:totalwithdrawl,:timestamp)", nativeQuery = true)
    @Transactional
    void insertdata(@Param("accountnumber") String accountnumber, @Param("totalwithdrawl") double totalwithdrawl, @Param("timestamp") java.sql.Timestamp  timestamp);




}
