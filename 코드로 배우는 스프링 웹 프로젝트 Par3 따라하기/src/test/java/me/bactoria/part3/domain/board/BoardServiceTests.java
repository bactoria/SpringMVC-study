package me.bactoria.part3.domain.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-config.xml")
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void 게시물을_정상적으로_등록한다() {
        // given
        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("bactoria");

        // when
        boardService.register(board);

        // then
        assertThat(board.getBno()).isNotNull();
    }

    private BoardVO makeBoard(String title, String content, String writer) {
        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        return board;
    }

    @Test
    public void 특정_게시물을_정상적으로_불러온다() {
        // given
        BoardVO board = new BoardVO();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("bactoria");
        boardService.register(board);

        final Long BNO = board.getBno();

        // when
        BoardVO result = boardService.get(BNO);

        // then
        assertThat(result.getBno()).isEqualTo(BNO);
    }

    @Test
    public void 모든_게시물들을_정상적으로_불러온다() {
        // given
        BoardVO board1 = makeBoard("제목1", "내용1", "bactoria");
        boardService.register(board1);

        BoardVO board2 = makeBoard("제목2", "내용2", "bactoria");
        boardService.register(board2);

        // when
        List<BoardVO> result = boardService.getList();

        // then
        assertThat(result).isNotEmpty();
    }

    @Test
    public void 특정_게시물의_제목을_정상적으로_수정한다() {
        // given
        final String NEW_TITLE = "수정한 제목";

        BoardVO board = makeBoard("제목", "내용", "bactoria");
        boardService.register(board);
        board.setTitle(NEW_TITLE);

        // when
        Boolean isChanged = boardService.modify(board);

        // then
        assertThat(isChanged).isTrue();
        assertThat(boardService.get(board.getBno()).getTitle()).isEqualTo(NEW_TITLE);
    }

    @Test
    public void 특정_게시물의_제목을_정상적으로_삭제한다() {
        // given
        BoardVO board = makeBoard("제목", "내용", "bactoria");
        boardService.register(board);

        final Long BNO = board.getBno();

        // when
        Boolean isDeleted = boardService.remove(BNO);

        // then
        assertThat(isDeleted).isTrue();
        assertThat(boardService.get(board.getBno())).isNull();
    }


}