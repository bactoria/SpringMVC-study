package me.bactoria.part3.domain.board;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria criteria);

    public int getTotal(Criteria criteria);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

}
