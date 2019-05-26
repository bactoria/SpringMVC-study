package me.bactoria.part3.mapper;

import me.bactoria.part3.domain.board.BoardVO;

import java.util.List;

public interface BoardMapper {

    // CREATE
    public void save(BoardVO board);
    public void insertSelectKey(BoardVO board);

    // READ
    public List<BoardVO> findAll();
    public BoardVO findById(Long bno);

    // UPDATE
    public int update(BoardVO board);
    public boolean updateB(BoardVO board);

    // DELETE
    public int deleteById(Long bno);
}
