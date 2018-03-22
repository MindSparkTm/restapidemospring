package com.restservice.controller;



import com.restservice.model.*;
import com.restservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@RestController
public class BankAccountController {


    @Autowired
    public TotalDepositService totalDepositService;

    @Autowired
    public AccountBalanceService balanceService;

    @Autowired
    public AccountDepositService depositService;


    @Autowired
    public WithdrawlService withdrawlService;


    @Autowired
    public TotalWithdrawlService totalWithdrawlService;



    @RequestMapping(value = "/api/v1/balance",method = RequestMethod.GET)
    public List<AccountBalance> getbalance(@RequestParam("accountnumber")String accountnumber){

        if (accountnumber.equals("1111")) {
            return balanceService.displaybalance(accountnumber) ;


        }
        else{
             return null;
        }

    }

    @RequestMapping(value = "/api/v1/deposit",method = RequestMethod.GET)
    public String  depositamount(@RequestParam("accountnumber")String accountnumber,@RequestParam("deposit")double deposit ){

        int flag =0;
        int totaldepositf = 0;
        if(deposit<=40000 & accountnumber.equals("1111")){

           //check the last row from the database and check the time and flag
            //if time is today and flag is 4 then the user has already exceeded the
            //maximum number of daily deposits
            System.out.println("ENtered");

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println("timestamp"+timeStamp);
            //getting the deposit records for the accountnumber
           List<AccountDeposit> ad = depositService.getlatestrecords();
           //getting the total deposit record per day for the accountnumber
           List<TotalDeposit>td = totalDepositService.getlatestrecords();


                System.out.println(ad.size());


                Iterator<AccountDeposit> i = ad.iterator();
                Iterator<TotalDeposit> j = td.iterator();

                AccountDeposit adeposit = ad.get(ad.size()-1);
                TotalDeposit totalDeposit = td.get(td.size() -1);


                System.out.println("jkkdk"+adeposit.getDepositamount());

                String lastdepositdate= adeposit.getTimestamp().toString();
                System.out.println("lastdepsit"+lastdepositdate);
                String formattedtime= timeStamp.substring(0,10);
                System.out.println("formattedtime"+formattedtime);

                //checking if last deposit date is current system date
            //this will now allow us to set up the flags for maximum deposits/day
            //this will also allow us to set up the flags for maximum depositamount/day

                if(lastdepositdate.contains(formattedtime)){
                    //checking the number of deposits as of the current date
                    int currentflag = (int)adeposit.getFlag();
                    //getting the latest total deposit to find out if the user has exceeded the maximum deposit amount/day
                    double totaldepositamount = totalDeposit.getTotaldeposit();
                    totaldepositamount = totaldepositamount + deposit;


                    System.out.println("flag"+currentflag);
                    if(currentflag<4 & totaldepositamount<=140000){
                        //insert the new deposit
                        System.out.println("Inserted");
                        currentflag ++;
                        //to update the deposit table to record the deposits/day
                        depositService.insertdata(accountnumber,deposit, Timestamp.valueOf(timeStamp),currentflag);

                        //updating the account balance after deposit
                        List<AccountBalance> abalance = balanceService.displaybalance(accountnumber);
                        AccountBalance abal = abalance.get(0);
                        double currentbalance = abal.getBalance();
                        double updatedbalance = currentbalance + deposit;
                        balanceService.updatebalance(updatedbalance,accountnumber);

                       //updating the total deposits by the user/day
                        totalDepositService.updatedata(totaldepositamount,accountnumber);

                       return "success";


                    }

                    else{
                        //you have exceeded the maximum number of deposits for the day
                     return "You have either exceeded the maximum number of deposits/ the maximum deposit amount";
                    }

                }

                else{
                    System.out.println("ENtered here");
                    //simply insert the new deposit. dont worry about the flag. THis is for a new day
                    depositService.insertdata(accountnumber,deposit, Timestamp.valueOf(timeStamp),flag);
                    totalDepositService.insertdata(accountnumber,deposit,Timestamp.valueOf(timeStamp));
                    flag++;

                 return "success";

            }














        }

        return "Something went wrong. Contact Bank";



    }







    @RequestMapping(value = "/api/v1/withdraw",method = RequestMethod.GET)
    public String withdrawlamount(@RequestParam("accountnumber")String accountnumber, @RequestParam("withdraw")double withdraw ){

        int flag =0;
        if(withdraw<=20000 & accountnumber.equals("1111")){

            //check the last row from the database and check the time and flag
            //if time is today and flag is 4 then the user has already exceeded the
            //maximum number of daily deposits
            System.out.println("ENteredkkllkkk");

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println("timestamp"+timeStamp);
            //getting the last withdrawl record from the database for the day and the number of withdrawls
            List<AccountWithdrawl> ad = withdrawlService.getlatestrecords();
            //getting the total withdrawl amaount for the day
            List<TotalWithdrawl> tw = totalWithdrawlService.getlatestrecords();
            System.out.println(ad.size());

            Iterator<AccountWithdrawl> i = ad.iterator();

            AccountWithdrawl awithdrawl = ad.get(ad.size()-1);

            Iterator<TotalWithdrawl> j = tw.iterator();

            TotalWithdrawl totalWithdrawl = tw.get(tw.size()-1);


            System.out.println("jkkdk"+awithdrawl.getWithdrawlamount());

            String lastwithdrawldate= awithdrawl.getTimestamp().toString() ;
            System.out.println("lastdepsit"+lastwithdrawldate);
            String formattedtime= timeStamp.substring(0,10);
            System.out.println("formattedtime"+formattedtime);
            if(lastwithdrawldate.contains(formattedtime)){
                int currentflag = (int)awithdrawl.getFlag();
                System.out.println("flag"+currentflag);
                if(currentflag<3){
                    //we are good to go for the day
                    System.out.println("Withdraw endpoint");
                    currentflag ++;

                    //getting the latest account balance to update if withdrawl is successful
                    List<AccountBalance> abalance = balanceService.displaybalance(accountnumber);
                    AccountBalance abal = abalance.get(0);
                    double currentbalance = abal.getBalance();
                    double updatedbalance = currentbalance - withdraw;

                    double totalwithdrawlamount = totalWithdrawl.getTotalwithdrawl();
                    totalwithdrawlamount = totalwithdrawlamount - withdraw;

                    if(currentbalance>1000 & updatedbalance>1000 & totalwithdrawlamount<=50000) {
                       System.out.println("--Entered");
                        balanceService.updatebalance(updatedbalance, accountnumber);
                        totalWithdrawlService.updatedata(totalwithdrawlamount,accountnumber);
                        withdrawlService.insertdata(accountnumber,withdraw,Timestamp.valueOf(timeStamp),currentflag);

                        return "success";
                    }

                    else{
                        //do something here
                        return "Insufficient funds /the maximum withdrawl amount exceeded";

                    }

                }

                else{
                    //you have exceeded the maximum number of deposits for the day
                   return "Maximum number of withdrawl attempts has been exceeded";
                }

            }

            else{
                System.out.println("ENtered here");
                //simply insert the new deposit. dont worry about the flag
                withdrawlService.insertdata(accountnumber,withdraw, Timestamp.valueOf(timeStamp),flag);
                flag++;
                return "success";


            }















        }
        return "Something went wrong. Contact Bank";




    }










}
