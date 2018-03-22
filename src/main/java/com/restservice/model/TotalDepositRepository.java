package com.restservice.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TotalDepositRepository extends CrudRepository<TotalDeposit, Long> {

    @Modifying
    @Transactional
    @Query("select t from TotalDeposit t order by t.id asc")
    public List<TotalDeposit> getlatestrecords();

    @Modifying
    @Transactional
    @Query("Update TotalDeposit t SET t.totaldeposit=:totaldeposit WHERE t.accountnumber=:accountnumber")
    public void updatebalance(@Param("totaldeposit") double totaldeposit, @Param("accountnumber") String accountnumber);


    @Modifying
    @Query(value = "insert into tbl_totaldeposit (accountnumber,totaldeposit,timestamp) VALUES (:accountnumber,:totaldeposit,:timestamp)", nativeQuery = true)
    @Transactional
    void insertdata(@Param("accountnumber") String accountnumber, @Param("totaldeposit") double totaldeposit, @Param("timestamp") java.sql.Timestamp  timestamp);



}
