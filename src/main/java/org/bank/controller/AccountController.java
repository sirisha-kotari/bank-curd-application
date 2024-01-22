package org.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.bank.model.Account;
import org.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        log.info("Account details {}", account);
        accountService.createAccount(account);
        return new ResponseEntity<>("Account created successfully!...", HttpStatus.OK);
    }
    @GetMapping("/account/{accountNumber}")
    public Optional<Account> getAcaccountNumcount(@PathVariable("accountNumber") String accountNumber){
        log.info("Trying to get Account details with Account Number {}" , accountNumber);
        Optional<Account> account = accountService.getAccountByAccountNumber(accountNumber);
        log.info("Account info found");
        return account;

    }

    @GetMapping("/accounts")
    public List<Account> accountList(){
        log.info("Trying to get all Accounts details  ");
        List<Account> accounts = accountService.getAllAccounts();
        log.info("Below Accounts info found");
        return accounts;
    }
@DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable("accountNumber") String accountNumber){
        accountService.deleteAccount(accountNumber);
        return new ResponseEntity<>("Account deleted successfully!...", HttpStatus.OK);
    }

    @PatchMapping("/update/{accountNumber}")
    private ResponseEntity<String> update(@PathVariable("accountNumber") String accountNumber, @RequestBody Account newAccountData) {

      accountService.updateAccount(accountNumber ,newAccountData);

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Account Updated successfully", HttpStatus.OK);

        return responseEntity;

    }
}

