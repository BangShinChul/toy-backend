package rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.model.Board;
import rest.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service  // BoardService를 Bean에 등록해줌
public class BoardServiceImpl implements BoardService {

    @Autowired // 등록된 Bean을 사용
    BoardRepository boardRepository;

    @Override
    @Transactional // 메서드 트랜잭션 설정 : 쿼리문이 처리도중 에러가 발생했을때 쿼리를 자동 rollback 해주기 위해서 사용
    public List<Board> findByUserId(String userId){
        return boardRepository.findByAccountUserId(userId).collect(Collectors.toList());
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }



    /*
    * 구현 클래스에서 BoardService를 구현한다.
    * findByWriter는 글쓴이ID(userId)로 게시목록을 찾는 기능이다.
    * boardRepository의 findByMember의 기능을 이용하였고
    * Stream으로 리턴받은 값을 List로 바꾸어 리턴해주었다.
    * */
}
