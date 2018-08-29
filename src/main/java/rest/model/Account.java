package rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userinfo") // 해당 클래스를 엔티티로 정의
@Data // lombok의 getter/setter
@AllArgsConstructor // 자동생성자
@NoArgsConstructor // 자동생성자
public class Account {

    @Id // pk 지정
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

}
