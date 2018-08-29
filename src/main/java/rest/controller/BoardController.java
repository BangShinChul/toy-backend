package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.model.Board;
import rest.service.BoardService;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController // 해당 클래스를 RestController로 만듬
@RequestMapping("/board") // 맵핑되는 url
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/writer/{userId}") // Type이 Get인 매핑
    public List<Board> findByWriter(@PathVariable String userId){
        // PathVariable : url의 {}에 들어간 값을 파싱해온다.
        // 변수 이름과 파싱해올 데이터 이름이 다르면 따로 선언해주어야한다.
        // BASE_URL + /board/writer/{userId}로 요청을 하면 해당 메서드가 실행된다.
        return boardService.findByUserId(userId);
    }

//    @GetMapping("/writer/{userId}") // Type이 Get인 매핑
//    public String findByWriter(@PathVariable String userId){
//        // PathVariable : url의 {}에 들어간 값을 파싱해온다.
//        // 변수 이름과 파싱해올 데이터 이름이 다르면 따로 선언해주어야한다.
//        // BASE_URL + /board/writer/{userId}로 요청을 하면 해당 메서드가 실행된다.
//        return userId;
//    }

    @GetMapping("/all")
    public List<Board> findAll(){
        return boardService.findAll();
    }

}
