package com.task3.service;

import com.task3.models.Account;
import com.task3.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    void testFindAll() {
        Account account = new Account(1L, "Petras", "Grigas", "+37068877111", "petro@gmail.com", "Vilniaus g. 1", "#123Slaptazodis");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        when(accountRepository.findAll()).thenReturn(accounts);
        List<Account> found = accountService.findAll();
        
        verify(accountRepository).findAll();
        assertEquals(1, found.size());
    }

    @Test
    void testFindById() throws Exception {
        Account account = new Account(1L, "Petras", "Grigas", "+37068877111", "petro@gmail.com", "Vilniaus g. 1", "#123Slaptazodis");
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));
        Account found_account = accountService.findById(1L);
        
        verify(accountRepository).findById(Mockito.anyLong());
        assertNotNull(found_account);
        assertEquals(account, found_account);
    }

    @Test
    void testUpdateAccount() throws Exception {
        Account account = new Account(1L, "Petras", "Grigas", "+37068877111", "petro@gmail.com", "Vilniaus g. 1", "#123Slaptazodis");
        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);
        when(accountRepository.existsById(1L)).thenReturn(true);
        Account updatedAccount = accountService.updateAccount(account);
        
        verify(accountRepository).save(Mockito.any(Account.class));
        assertEquals(account, updatedAccount);
    }

    @Test
    void testCreateAccount() throws Exception {
        Account account = new Account(1L, "Petras", "Grigas", "+37068877111", "petro@gmail.com", "Vilniaus g. 1", "#123Slaptazodis");
        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);
        Account new_account = accountService.createAccount(account);
        
        verify(accountRepository).save(Mockito.any(Account.class));    
        assertNotNull(new_account);
        assertEquals(account, new_account);
    }

    @Test
    void testDeleteAccountById() {
        accountService.deleteAccountById(1L);
        
        verify(accountRepository).deleteById(Mockito.anyLong());
    }
}