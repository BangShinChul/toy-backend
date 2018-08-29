package rest.repository;

import rest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUserId(String userId);
    // findByUserId : Account 엔티티에서 userId로 유저목록을 가져오는 기능이다.

    List<Account> findByUserEmail(String userEmail);
    // findByUserEmail : Account 엔티티에서 userEmail로 유저목록을 가져오는 기능이다.
}
