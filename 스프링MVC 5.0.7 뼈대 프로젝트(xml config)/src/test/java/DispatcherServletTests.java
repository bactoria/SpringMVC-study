import me.bactoria.ex01.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcherServlet-config.xml", "file:src/main/resources/spring/root-config.xml"})
public class DispatcherServletTests {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void 디스패쳐서블릿에_뷰리졸버가_등록되어있다() {
        ViewResolver viewResolver = ctx.getBean(ViewResolver.class);
        assertThat(viewResolver).isNotNull();
    }

    @Test
    public void 디스패쳐서블릿에_Handler_Mapping이_등록되어있다() {
        HandlerMapping handlerMapping = ctx.getBean(RequestMappingHandlerMapping.class);
        assertThat(handlerMapping).isNotNull();
    }
}
