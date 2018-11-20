package rest.service;

import rest.model.Account;
import rest.model.Login;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    List<Account> findByUserId(String userId);
    List<Account> doLoginCheck(Login loginCheck); // 로그인 체크용 메서드
    List<Account> findByUserPassword(String userId);
    List<Account> findByUserEmail(String userEmail);
    Object signUp(Account userInfo);
}
