import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-config.xml")
public class mapperTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void sqlSessionFactory의_connection을_가지고_온다() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();
        ) {
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

}
