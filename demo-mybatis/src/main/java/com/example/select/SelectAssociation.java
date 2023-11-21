package com.example.select;

import com.example.MySessionFactory;
import com.example.mapper.BlogMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class SelectAssociation {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession =  MySessionFactory.getSessionFactory().openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        System.out.println(mapper.selectContainAuthor(1).getContent());
    }
}
