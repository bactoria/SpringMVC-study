package me.bactoria.part4.domain.sample;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class SampleRestControllerTest {


    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void 티켓테스트() throws Exception {

        // given
        final int TNO = 123;
        final String OWNER= "Admin";
        final String GRADE= "AAA";

        Ticket ticket = new Ticket();
        ticket.setTno(TNO);
        ticket.setOwner(OWNER);
        ticket.setGrade(GRADE);

        final String CONTENT = new Gson().toJson(ticket);

        // when
        mockMvc.perform(post("/samples/ticket")
                .accept(MediaType.APPLICATION_JSON_UTF8)

                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(CONTENT))

                // then
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.tno", is(TNO)))
                .andExpect(jsonPath("$.owner", is(OWNER)))
                .andExpect(jsonPath("$.grade", is(GRADE)));
    }
}