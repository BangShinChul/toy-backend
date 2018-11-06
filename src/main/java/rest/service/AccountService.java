package rest.service;

import rest.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    List<Account> findByUserId(String userId);
    List<Account> findByUserEmail(String userEmail);
    Object signUp(Account userInfo);
}
