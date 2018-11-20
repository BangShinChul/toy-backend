package rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok의 getter/setter
@AllArgsConstructor // 자동생성자
@NoArgsConstructor // 자동생성자
public class Login {
    private String userId;
    private String userPassword;
}
