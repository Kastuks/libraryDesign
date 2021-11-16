package com.task3.controller;

import com.task3.models.Account;
import com.task3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping()
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) throws Exception {
        return accountService.findById(accountId);
    }

    @PostMapping()
    public Account createAccount(@RequestBody Account account) throws Exception {
        return accountService.createAccount(account);
    }
    
//    @PostMapping()
//    public Account createAcc(ModelMap model, @ModelAttribute("account") Account account, BindingResult result) throws Exception {
//    	
//        return accountService.createAccount(account);
//    }
    
    @PutMapping()
    public Account updateAccountById(@RequestBody Account accountInfo) throws Exception {
        return accountService.updateAccount(accountInfo);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
    }
}