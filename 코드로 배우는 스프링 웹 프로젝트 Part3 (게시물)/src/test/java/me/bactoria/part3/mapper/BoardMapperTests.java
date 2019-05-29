package me.bactoria.part3.mapper;

import lombok.extern.slf4j.Slf4j;
import me.bactoria.part3.domain.board.BoardVO;
import me.bactoria.part3.domain.board.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-config.xml")
public class BoardMapperTests {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void 모든_게시물을_정상적으로_불러온다() {
        mapper.findAll().forEach(board -> log.info(String.valueOf(board)));
    }

    @Test
    public void Insert를_사용하여_저장하면_bno가_비어있다() {
        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("주노");

        mapper.save(board);

        assertThat(board.getBno()).isNull();
    }

    @Test
    public void InsertSelectKey를_사용하여_저장하면_bno에_값이_존재한다() {
        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("주노");

        mapper.saveSelectKey(board);

        assertThat(board.getBno()).isNotNull();
    }

    @Test
    public void 게시글을_성공적으로_불러온다() {
        // given
        final Long BNO = 1L;

        // when
        BoardVO board = mapper.findById(BNO);

        // then
        assertThat(board).isNotNull();
    }

    @Test
    public void 게시글을_정상적으로_수정한다() {
        // given
        final int UPDATED_BOARD_COUNT = 1;
        final String NEW_TITLE = "수정된 제목";

        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("주노");
        mapper.saveSelectKey(board);

        board.setTitle(NEW_TITLE);

        // when
        int updatedBoardCount = mapper.update(board);

        // then
        assertThat(updatedBoardCount).isEqualTo(UPDATED_BOARD_COUNT);
    }

    @Test
    public void 게시글을_정상적으로_삭제한다() {
        // given
        final int DELETED_BOARD_COUNT = 1;

        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("주노");
        mapper.saveSelectKey(board);

        final Long BNO = board.getBno();

        // when
        int result = mapper.deleteById(BNO);

        // then
        assertThat(result).isEqualTo(DELETED_BOARD_COUNT);
    }

    @Test
    public void 페이지를_정상적으로_불러온다() {

        // given
        Criteria criteria = new Criteria(1, 10);

        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("주노");
        mapper.saveSelectKey(board);

        // when
        List<BoardVO> boards = mapper.findPage(criteria);

        // then
        assertThat(boards).isNotEmpty();
    }

    @Test
    public void 검색_시_SQL이_정상적으로_실행된다() {

        Criteria criteria = new Criteria();
        criteria.setKeyword("제목");
        criteria.setType("TC");

        List<BoardVO> boards = mapper.findPage(criteria);

        boards.forEach(board -> {
            log.info("board: {}", board);
        });
    }
}