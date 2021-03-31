package com.aymax.forum.mapper;

import com.aymax.forum.dto.CommentDto;
import com.aymax.forum.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CommentMapper extends EntityMapper<CommentDto, Comment> {
}
