package org.bank.service;

import lombok.extern.slf4j.Slf4j;
import org.bank.model.Account;
import org.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {

        Account newAccount = accountRepository.save(account);

        return newAccount;
    }

    public Optional<Account> getAccountByAccountNumber(String accountNumber) {

        Optional<Account> acc = accountRepository.findById(accountNumber);
        return acc;
    }

    public List<Account> getAllAccounts() {

        log.info("Trying to get Account details");
        List<Account> accounts = accountRepository.findAll();

        if (!CollectionUtils.isEmpty(accounts)) {
            log.info("accounts Size {}", accounts.size());
        }
        return accounts;
    }
    public void deleteAccount(String accountNumber){
        log.info("Trying to get Account details");
        if(!(accountNumber ==null)){
        accountRepository.findAll();
           log.info("Account deleted successfully with accountNumber: {}" , accountNumber);
        }


    }

    public Account  updateAccount(String accountNumber, Account newAccount){
        log.info("Trying to update AccountNumber {}" , accountNumber);
        Optional<Account> oldAccountData =accountRepository.findById(accountNumber);
             if (oldAccountData.isPresent()) {
               Account updatedAccount = oldAccountData.get();
                 updatedAccount .setPhoneNum(newAccount.getPhoneNum());
                accountRepository.save(updatedAccount);
            }
            log.info("Account Number {} - updated successfully" , accountNumber);
        return newAccount;
        }




}
