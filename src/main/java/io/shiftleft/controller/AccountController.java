package io.shiftleft.controller;

import io.shiftleft.data.DataLoader;
import io.shiftleft.model.Account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.shiftleft.repository.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Admin checks login
 */

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    private static Logger log = LoggerFactory.getLogger(DataLoader.class);
    
    @GetMapping("/account")
    public Iterable<Account> getAccountList(HttpServletResponse response, HttpServletRequest request) {
        response.addHeader("test-header-detection", new Account().toString());
        log.info("Account Data is {}", this.accountRepository.findOne(1l).toString());
        return this.accountRepository.findAll();
    }

	@PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        this.accountRepository.save(account);
        log.info("Account Data is not logged due to sensitive information");
        return account;
    }

        return account;
    }

    @GetMapping("/account/{accountId}")
    public Account getAccount(@PathVariable long accountId) {
        log.info("Account Data is {}", this.accountRepository.findOne(1l).toString());
        return this.accountRepository.findOne(accountId);
    }

	@PostMapping("/account/{accountId}/deposit")
    public Account depositIntoAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        // Removed the log statement
        account.deposit(amount);
        this.accountRepository.save(account);
        return account;
    }

    public Account depositIntoAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        log.info("Account Data is {}", account.toString());
        account.deposit(amount);
        this.accountRepository.save(account);
        return account;
    }

	@PostMapping("/account/{accountId}/withdraw")
    public Account withdrawFromAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found with id: " + accountId);
        }
        // Check if the amount to withdraw is less than or equal to the account's balance
        if (amount > account.getBalance()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.withdraw(amount);
        this.accountRepository.save(account);
        log.info("Account Data is {}", account.toString());
        return account;
    }

    public Account withdrawFromAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found with id: " + accountId);
        }
        account.withdraw(amount);
        this.accountRepository.save(account);
        log.info("Account Data is {}", account.toString());
        return account;
    }

    public Account withdrawFromAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        account.withdraw(amount);
        this.accountRepository.save(account);
        log.info("Account Data is {}", account.toString());
        return account;
    }

    @PostMapping("/account/{accountId}/addInterest")
    public Account addInterestToAccount(@RequestParam double amount, @PathVariable long accountId) {
        Account account = this.accountRepository.findOne(accountId);
        account.addInterest();
        this.accountRepository.save(account);
        log.info("Account Data is {}", account.toString());
        return account;
    }

}




