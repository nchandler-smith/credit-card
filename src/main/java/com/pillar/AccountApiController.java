package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {
    private CardholderRepository cardholderRepository;

    public AccountApiController(CardholderRepository cardholderRepository) {
        this.cardholderRepository = cardholderRepository;
    }

    public AccountApiController() {}

    public List<Cardholder> getAll() { return cardholderRepository.findAll(); }

    public Account createAccount(Cardholder cardholder){
        Account account = new Account(cardholder);
        return account;
    }

    @RequestMapping(path = "/create", method = {RequestMethod.POST})
    public ResponseEntity<Account> createAccount(HashMap<String, String> accountInfo){
        Account account = new Account();
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
}
