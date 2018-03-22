package com.restservice.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AmountdepositRepository extends CrudRepository<AccountDeposit, Long> {

    @Modifying
    @Transactional
    @Query("SELECT t FROM AccountDeposit t WHERE t.accountnumber= ?1")
    public List<AccountDeposit> checkflag(String accountnumber);

    @Modifying
    @Transactional
    @Query("select t from AccountDeposit t order by t.id asc")
    public List <AccountDeposit> getlatestrecords();


    @Modifying
    @Query(value = "insert into tbl_deposit (accountnumber,depositamount,timestamp,flag) VALUES (:accountnumber,:depositamount,:timestamp,:flag)", nativeQuery = true)
    @Transactional
    void insertdata(@Param("accountnumber") String accountnumber, @Param("depositamount") double depositamount,@Param("timestamp") java.sql.Timestamp  timestamp,@Param("flag")long flag);


}
