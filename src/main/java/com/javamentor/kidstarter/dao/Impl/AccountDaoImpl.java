package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.AccountDao;
import com.javamentor.kidstarter.model.user.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AccountDaoImpl extends AbstractDao<Long, Account> implements AccountDao {
}
