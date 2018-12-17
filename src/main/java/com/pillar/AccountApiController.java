package com.pillar;

import com.pillar.account.Account;
import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private CardholderRepository cardholderRepository;

    public AccountApiController(CardholderRepository cardholderRepository) {
        this.cardholderRepository = cardholderRepository;
    }

    public List<Cardholder> getAll() { return cardholderRepository.findAll(); }

    public Account createAccount(){
        Account account = new Account();
        return account;
    }

    @RequestMapping(path = "/create", method = {RequestMethod.POST})
    public ResponseEntity<Account> createAccount(@RequestBody Map<String, String> params){
        final String name = params.get("cardholderName");
        final String ssn = params.get("ssn");
        Cardholder cardholder = new Cardholder(name, ssn);
        cardholder = cardholderRepository.save(cardholder);
        Account account = new Account();
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
}
