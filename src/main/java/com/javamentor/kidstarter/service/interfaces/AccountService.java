package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Account;

import java.util.List;

public interface AccountService {

	Account getAccountId(Long id);
	Account addAccount(Account account);
	List<Account> getAllAccount();
	void deleteAccountById(Long id);
	void updateAccount(Account account);
}
