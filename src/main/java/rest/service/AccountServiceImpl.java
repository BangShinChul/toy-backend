package rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.model.Account;
import rest.model.Login;
import rest.repository.AccountRepository;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    // 모든 유저의 목록을 가져오는 기능이다.

    @Override
    public List<Account> findByUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public List<Account> doLoginCheck(Login loginCheck) {
        String userId = loginCheck.getUserId();
        String userPassword = loginCheck.getUserPassword();

        return accountRepository.findByUserIdAndUserPassword(userId, userPassword);
    }

    @Override
    public List<Account> findByUserPassword(String userId) {
        return accountRepository.findByUserPassword(userId);
    }

    @Override
    public List<Account> findByUserEmail(String userEmail) {
        return accountRepository.findByUserEmail(userEmail);
    }


    @Override
    public Object signUp(Account account) {
        return accountRepository.save(account);
    }
}
