package com.task3.repository;

import org.springframework.data.repository.CrudRepository;

import com.task3.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	
	
}
