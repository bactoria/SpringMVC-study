package controller;

import me.bactoria.ex01.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcherServlet-config.xml", "file:src/main/resources/spring/root-config.xml"})
public class HelloControllerTest {

    private MockMvc mockMvc;

    @Autowired
    HelloController helloController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void ApplicationContext에_빈을_주입_성공() {
        assertThat(helloController).isNotNull();
    }
}
