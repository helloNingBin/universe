package com.example.mapper;

import com.example.model.PostTag;
import com.example.model.PostTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostTagMapper {
    long countByExample(PostTagExample example);

    int deleteByExample(PostTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PostTag record);

    int insertSelective(PostTag record);

    List<PostTag> selectByExample(PostTagExample example);

    PostTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PostTag record, @Param("example") PostTagExample example);

    int updateByExample(@Param("record") PostTag record, @Param("example") PostTagExample example);

    int updateByPrimaryKeySelective(PostTag record);

    int updateByPrimaryKey(PostTag record);
}