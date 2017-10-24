package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleCommentEntity;
import com.manba.simple.domain.inside.CommentEntityRequest;

import java.util.List;

public interface ManSimpleCommentEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleCommentEntity record);

    int insertSelective(ManSimpleCommentEntity record);

    ManSimpleCommentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleCommentEntity record);

    int updateByPrimaryKey(ManSimpleCommentEntity record);

    List<ManSimpleCommentEntity> selectComments(CommentEntityRequest request);
}