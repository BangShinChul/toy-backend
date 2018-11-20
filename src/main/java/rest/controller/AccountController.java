package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.model.Account;
import rest.model.Login;
import rest.model.Point;
import rest.repository.PointRedisRepository;
import rest.service.AccountService;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController // @Controller와 @ResponseBody의 조합으로 특정 객체 리턴 시 자동으로 JSON 오브젝트로 마샬링하여 Response 해줌.
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @GetMapping("/all")
    public List<Account> findAll(){
        // BASE_URL + /account
        // DB에 등록된 모든 account를 불러온다
        return accountService.findAll();
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestBody Login login){
         String result = "UserId : " + login.getUserId() +" / UserPassword : " + login.getUserPassword();
//        List<Account> idCheck = accountService.findByUserId(login.getUserId());
//        List<Account> emailCheck = accountService.findByUserEmail(login.getUserId());
//        List<Account> loginCheck = accountService.findByUserId(login);
        List<Account> loginCheck = accountService.doLoginCheck(login);
//        if(idCheck.isEmpty() && emailCheck.isEmpty()){
        if(loginCheck.isEmpty()){
            System.out.println("=========================");
            System.out.println("login: "+result+"\nloginCheck: "+loginCheck);
            System.out.println("=========================");
            return "0001"; // 회원정보가 없을 때 혹은 비밀번호가 맞지 않을 때
        }else {
            String id = login.getUserId();
            LocalDateTime refreshTime = LocalDateTime.now();
            Point point = Point.builder()
                    .id(id)
                    .refreshTime(refreshTime)
                    .build();

            // 위에서 설정한 로그인정보 객체 redis에 저장
            pointRedisRepository.save(point);

            Point savePoint = pointRedisRepository.findById(id).get();
            if(savePoint.getId().equals(id) && savePoint.getRefreshTime().equals(refreshTime)){
                return "0000"; // 성공
            }else {
                return "0002"; // 로그인은 되었지만 redis에 세션관리가 안됨
            }
        }
    }

    @PostMapping("/doLogout")
    public String doLogout(@RequestBody Account account) {
        String userId = account.getUserId();
        System.out.println(userId);
        Point savePoint = pointRedisRepository.findById(userId).get();
        if(!savePoint.getId().isEmpty()) {
            // 세션값이 있을 때

            // 해당 id값으로 저장된 redis 데이터 삭제
            pointRedisRepository.deleteById(userId);
            return "0000"; // 세션삭제 성공 = 로그아웃 성공
        }else {
            // 세션값이 없을 때
            return "0001";
        }
    }

    @PostMapping("/checkAccount")
    public String checkAccount(@RequestBody Login login){
        // String result = "UserId : "+userId+" / UserPassword : "+userPassword;
        List<Account> idCheck = accountService.findByUserId(login.getUserId());
        List<Account> emailCheck = accountService.findByUserEmail(login.getUserId());
        if(idCheck.isEmpty() && emailCheck.isEmpty()){
            return "0001"; // 회원정보가 없을 때
        }else {
            return "0000"; // 성공
        }
    }

    @GetMapping("/testLogin")
    public Object getLogin(@RequestBody Login login){
        return login;
    }

    @PostMapping("/signUp")
    public Object signUp(@RequestBody Account account){
        // String result = "UserId : "+userId+" / UserPassword : "+userPassword;
        List<Account> idCheck = accountService.findByUserId(account.getUserId());
        List<Account> emailCheck = accountService.findByUserEmail(account.getUserEmail());

        if(idCheck.isEmpty() && emailCheck.isEmpty()){
            // 아이디와 이메일이 중복되지 않을때 insert
            return accountService.signUp(account);
        }else {
            return "0000"; // 중복됨
        }
    }

//    @PostMapping("/getAccount")
//    @ResponseBody
//    public Boolean getAccount(
//            @RequestParam String userId,
//            @RequestParam String userPassword,
//            @RequestParam String userEmail,
//            @RequestParam String userName
//    ){
//        Account account = new Account(userId, userPassword, userEmail, userName);
//
//        String test = account.getUserId();
//        if(test != null){
//            return true;
//        }else {
//            return false;
//        }
//    }
}
