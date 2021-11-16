package com.task3.service;

import com.task3.models.Account;
import com.task3.repository.AccountRepository;
import pair.main.java.EmailChecker;
import pair.main.java.PasswordChecker;
import pair.main.java.PhoneChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AccountService {
    private final static String ACC_NOT_VALID_MSG = "Account is not valid";
    private final static String ACC_NOT_EXIST_MSG = "Account does not exist";
    
    private static StringBuilder zeroes = new StringBuilder("000");
    private List<Character> domainSymbols ; 
    private List<Character> localSymbols ;
    private List<Character> specialSymbols ;
    public HashMap<String, Integer> validationRules;
    private HashMap<String, String> internationalCodes;
    
    @Autowired
    private AccountRepository accountRepository;

    private EmailChecker emailValidator ;
    private PasswordChecker passwordValidator ;
    private PhoneChecker phoneValidator ;

    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account findById(Long accountId) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new Exception(ACC_NOT_EXIST_MSG);
        }

        return accountOptional.get();
    }

    public Account createAccount(Account account) throws Exception {
    	 
        if (account == null) {
            throw new Exception("Account is null");
        }

        if (!accountNotValid(account).equals("000")) {
            throw new Exception();
        }

        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) throws Exception {
        if (account == null || account.getId() == 0L) {
            throw new Exception("Account id cant be null");
        }
        if (!accountNotValid(account).equals("000")) {
            throw new Exception(ACC_NOT_VALID_MSG);
        }
        if (!accountRepository.existsById(account.getId())) {
            throw new Exception(ACC_NOT_EXIST_MSG);
        }

        return accountRepository.save(account);
    }

    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    private String accountNotValid(Account accountInfo) {
    	domainSymbols = IntStream.concat(
                IntStream.rangeClosed('a', 'd'),
                IntStream.rangeClosed('d', 'z')
        ).mapToObj(c -> (char) c).collect(Collectors.toList());
    	localSymbols = IntStream.concat(
                IntStream.rangeClosed('0', '9'),
                IntStream.rangeClosed('a', 'Z')
        ).mapToObj(c -> (char) c).collect(Collectors.toList());
    	specialSymbols = "!#$%&'*+-/=?^_`{|}~".chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

    	validationRules = new HashMap<String, Integer>();
        internationalCodes = new HashMap<String, String>();

        validationRules.put("+370", 8);
        internationalCodes.put("8", "+370");
    	
    	
    	emailValidator = new EmailChecker(50, 10, localSymbols , domainSymbols);
        passwordValidator = new PasswordChecker(8, specialSymbols);
        phoneValidator = new PhoneChecker(validationRules, internationalCodes);

        boolean emailValid = emailValidator.validate(accountInfo.getEmail());
        boolean passwordValid = passwordValidator.validate(accountInfo.getPassword());
        boolean phoneValid = phoneValidator.validate(accountInfo.getPhoneNumber());
        
        StringBuilder stringBuilder = new StringBuilder();

        if(emailValid)  stringBuilder.append("0"); else stringBuilder.append("1");
        if(passwordValid)  stringBuilder.append("0"); else stringBuilder.append("1");
        if(phoneValid)  stringBuilder.append("0"); else stringBuilder.append("1");
        
        
        return stringBuilder.toString();
        
        
    }

}