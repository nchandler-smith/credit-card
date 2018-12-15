package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;

import java.util.List;

public class AccountApiController {
    private CardholderRepository cardholderRepository;

    public AccountApiController(CardholderRepository cardholderRepository) {
        this.cardholderRepository = cardholderRepository;
    }

    public AccountApiController() {

    }

    public List<Cardholder> getAll() { return cardholderRepository.findAll(); }

    public Account createAccount(Cardholder cardholder){
        Account account = new Account(cardholder);
        return account;
    }
}
