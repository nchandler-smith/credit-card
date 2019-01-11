package com.pillar;

import com.pillar.account.Account;
import com.pillar.account.AccountRepository;
import com.pillar.cardholder.Cardholder;
import com.pillar.cardholder.CardholderRepository;
import com.pillar.merchant.Merchant;
import com.pillar.merchant.MerchantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private CardholderRepository cardholderRepository;
    private MerchantRepository merchantRepository;
    private AccountRepository accountRepository;

    public AccountApiController(CardholderRepository cardholderRepository,
                                MerchantRepository merchantRepository,
                                AccountRepository accountRepository) {
        this.cardholderRepository = cardholderRepository;
        this.merchantRepository = merchantRepository;
        this.accountRepository = accountRepository;
    }

    public Account createAccount(){
        Account account = new Account();
        return account;
    }

    @RequestMapping(path = "/create", method = {RequestMethod.POST})
    public ResponseEntity<Account> createAccount(@RequestBody Map<String, String> params){
        final String name = params.get("cardholderName");
        final String ssn = params.get("ssn");
        final String merchantName = params.get("merchantName");

        final Cardholder cardholder = cardholderRepository.save(new Cardholder(name, ssn));
        final Merchant merchant = merchantRepository.findByName(merchantName)
            .orElseGet(() -> merchantRepository.save(new Merchant(merchantName)));

        Account account = new Account(cardholder, merchant);
        account = accountRepository.save(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
}
