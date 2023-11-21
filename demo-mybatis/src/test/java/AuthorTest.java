import com.example.MySessionFactory;
import com.example.mapper.AuthorMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AuthorTest {
    SqlSession sqlSession;
    AuthorMapper authorMapper;

    @Before
    public void init() throws IOException {
        sqlSession =  MySessionFactory.getSessionFactory().openSession();
        authorMapper = sqlSession.getMapper(AuthorMapper.class);
    }
}
