package me.bactoria.part3.domain.board;

import lombok.RequiredArgsConstructor;
import me.bactoria.part3.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        mapper.saveSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        return mapper.findById(bno);
    }

    @Override
    public List<BoardVO> getList() {
        return mapper.findAll();
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        return mapper.findPage(criteria);
    }

    @Override
    public int getTotal(Criteria criteria) {
        return mapper.getTotalCount(criteria);
    }

    @Override
    public boolean modify(BoardVO board) {
        boolean isChanged = mapper.update(board) == 1;
        return isChanged;
    }

    @Override
    public boolean remove(Long bno) {
        boolean isDeleted = mapper.deleteById(bno) == 1;
        return isDeleted;
    }
}
