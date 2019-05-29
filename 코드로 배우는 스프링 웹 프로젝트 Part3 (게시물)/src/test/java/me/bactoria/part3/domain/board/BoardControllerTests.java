package me.bactoria.part3.domain.board;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-config.xml",
        "file:src/main/webapp/WEB-INF/dispatcherServlet-config.xml"})
@WebAppConfiguration
public class BoardControllerTests {

    @Autowired
    WebApplicationContext ctx;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void 게시물_리스트_불러오기_테스트() throws Exception {

        mockMvc.perform(get("/board/list")
                        .param("pageNum", "3")
                        .param("amount", "10"))

                .andExpect(status().isOk())
                .andExpect(handler().handlerType(BoardController.class))
                .andExpect(handler().methodName("list"))
                .andExpect(model().attributeExists("list"))
                .andExpect(view().name("board/list"));
    }

    @Test
    public void 게시물_등록_테스트() throws Exception {

        mockMvc.perform(post("/board/register")
                .param("title", "테스트 제목")
                .param("content", "테스트 내용")
                .param("writer", "유저"))

                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(handler().handlerType(BoardController.class))
                .andExpect(handler().methodName("register"))
                .andExpect(flash().attributeCount(1))
                .andExpect(flash().attributeExists("result"))
                .andExpect(redirectedUrl("/board/list"));
    }

    /*
     * 해당 BNO의 게시물이 존재하는지 사전에 확인 해야 함.
     * */
    @Test
    public void 게시물_불러오기_테스트() throws Exception {

        final String BNO = "2";

        mockMvc.perform(get("/board/get")
                .param("bno", BNO))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(BoardController.class))
                .andExpect(handler().methodName("get"))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("board"))
                .andExpect(view().name("board/get"));
    }

    /*
     * 해당 BNO의 게시물이 존재하는지 사전에 확인 해야 함.
     * */
    @Test
    public void 게시물_수정_테스트() throws Exception {

        MultiValueMap board = new LinkedMultiValueMap();
        board.add("bno","2");
        board.add("title","수정된 제목");
        board.add("content","수정된 내용");
        board.add("writer","bactoria");

        mockMvc.perform(post("/board/modify")
                .params(board))

                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(handler().handlerType(BoardController.class))
                .andExpect(handler().methodName("modify"))
                .andExpect(flash().attributeCount(1))
                .andExpect(flash().attribute("result", "success"))
                .andExpect(redirectedUrl("/board/list"));
    }

    /*
    * 해당 BNO의 게시물이 존재하는지 사전에 확인 해야 함.
    * */
    @Test
    public void 게시물_삭제_테스트() throws Exception {

        final String BNO = "2";

        mockMvc.perform(post("/board/delete")
                .param("bno", BNO))

                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(handler().handlerType(BoardController.class))
                .andExpect(handler().methodName("delete"))
                .andExpect(flash().attributeCount(1))
                .andExpect(flash().attributeExists("result"))
                .andExpect(redirectedUrl("/board/list"));
    }
}