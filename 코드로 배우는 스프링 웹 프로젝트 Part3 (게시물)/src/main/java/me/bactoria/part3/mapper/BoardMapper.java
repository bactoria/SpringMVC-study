package me.bactoria.part3.mapper;

import me.bactoria.part3.domain.board.BoardVO;
import me.bactoria.part3.domain.board.Criteria;

import java.util.List;

public interface BoardMapper {

    // CREATE
    public void save(BoardVO board);
    public void saveSelectKey(BoardVO board); // Integer 반환?

    // READ
    public List<BoardVO> findAll();
    public List<BoardVO> findPage(Criteria criteria);
    public BoardVO findById(Long bno);
    public int getTotalCount(Criteria criteria);

    // UPDATE
    public int update(BoardVO board);

    // DELETE
    public int deleteById(Long bno);

}
