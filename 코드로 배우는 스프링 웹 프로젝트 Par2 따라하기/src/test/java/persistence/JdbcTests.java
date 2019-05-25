package persistence;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;


public class JdbcTests {

    @Test
    public void ojdbc라이브러리가_classpath에_있다() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            fail("OJDBC 의존성 없음");
        }
    }

    @Test
    public void ojdbc가_정상적으로_등록되었다() throws Exception {
        // given
        final String URL = "jdbc:oracle:thin:@oracleinstance.cx7jjgoxhl1w.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
        final String USERNAME = "scott";
        final String PASSWORD = "qwer1234";

        // when
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        // then
        assertThat(con).isNotNull(); // 무의미. 위에서 Exception으로 걸러짐.
    }
}
