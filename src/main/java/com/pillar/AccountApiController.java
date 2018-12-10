package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;

public class AccountApiController {

    public Account createAccount(Cardholder cardholder){
        Account account = new Account(cardholder);
        return account;
    }
}
