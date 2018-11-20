package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rest.model.Account;
import rest.model.Login;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUserId(String userId);
    // findByUserId : Account 엔티티에서 userId로 유저목록을 가져오는 기능이다.

    // @Query("SELECT user_id from userinfo where user_id = :#{#id} and user_password = :#{#password}")
//    @Query(value = "SELECT a.userId from userinfo a where a.userId = :#{#loginCheck.userId} and a.userPassword = :#{#loginCheck.userPassword} ", nativeQuery = false)
    @Query(value = "SELECT user_id from userinfo where user_Id = :#{#loginCheck.userId} and user_password = :#{#loginCheck.userPassword}", nativeQuery = true)
    List<Account> findByUserId(@Param("loginCheck")Login loginCheck);

    List<Account> findByUserPassword(String userId);

    List<Account> findByUserIdAndUserPassword(String userId, String userPassword);

    List<Account> findByUserEmail(String userEmail);
    // findByUserEmail : Account 엔티티에서 userEmail로 유저목록을 가져오는 기능이다.

}
