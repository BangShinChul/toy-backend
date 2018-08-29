package rest.service;

import rest.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> findByUserId(String userId);
    List<Board> findAll();
}
