package persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/root-config.xml"})
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void 커넥션을_DataSource에게_받아올_수_있다() {
        try(Connection con = dataSource.getConnection()){
            log.info(String.valueOf(con));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
