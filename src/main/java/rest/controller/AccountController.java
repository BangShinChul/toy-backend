package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.model.Account;
import rest.model.Login;
import rest.service.AccountService;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController // @Controller와 @ResponseBody의 조합으로 특정 객체 리턴 시 자동으로 JSON 오브젝트로 마샬링하여 Response 해줌.
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public List<Account> findAll(){
        // BASE_URL + /account
        // DB에 등록된 모든 account를 불러온다
        return accountService.findAll();
    }

//    @PostMapping("/doLogin")
//    public String doLogin(
//            @RequestParam(name="userId", required=true) String userId,
//            @RequestParam(name="userPassword", required=true) String userPassword){
//        String result = "UserId : "+userId+" / UserPassword : "+userPassword;
//        return result;
//    }
    @PostMapping("/doLogin")
    public String doLogin(@RequestBody Login login){
        // String result = "UserId : "+userId+" / UserPassword : "+userPassword;
        List<Account> idCheck = accountService.findByUserId(login.getUserId());
        List<Account> emailCheck = accountService.findByUserEmail(login.getUserId());
        if(idCheck.isEmpty() && emailCheck.isEmpty()){
            return "0001"; // 회원정보가 없을 때
        }else {
            return "0000"; // 성공
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

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Account Test";
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
