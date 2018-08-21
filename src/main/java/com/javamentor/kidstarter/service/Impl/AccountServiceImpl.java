package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.AccountDao;
import com.javamentor.kidstarter.model.user.Account;
import com.javamentor.kidstarter.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account getAccountId(Long id) {
		return accountDao.getByKey(id);
	}

	@Override
	public Account addAccount(Account account) {
		accountDao.persist(account);
		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		return accountDao.getAll();
	}

	@Override
	public void deleteAccountById(Long id) {
    accountDao.deleteByKey(id);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.update(account);
	}
}
