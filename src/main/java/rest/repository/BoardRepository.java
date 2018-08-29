package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.model.Board;

import java.util.stream.Stream;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Stream<Board> findByAccountUserId(String userId);

    // JpaRepository 클래스를 상속받아서 기본적인 CRUD 기능을 사용함
    // JpaRepository 클래스는 CrudRepository를 상속받고 있어
    // 기본적인 findAll, findOne, save등의 CRUD를 할 수 있다.

    // 또한 Qurey Method를 이용해 원하는 데이터값을 불러올 수 있다.
    // 위의 코드는 findByUserId로 Board 엔티티의 멤버를 이용하여 게시목록을 얻어오는 기능이다.

}
