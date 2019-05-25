package persistence;

import lombok.extern.slf4j.Slf4j;
import me.bactoria.ex01.mapper.AccountMapper;
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

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/root-config.xml"})
public class MyBatisTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void sqlSessionFactory의_connection을_가지고_온다() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();
        ) {
            log.info(String.valueOf(session));
            log.info(String.valueOf(con));
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void accountMapper가_정상적으로_주입된다() {
        log.info(accountMapper.getClass().getName());
        log.info(accountMapper.getAccount());
        log.info(accountMapper.getAccount2());
        assertThat(accountMapper).isNotNull();
    }
}
