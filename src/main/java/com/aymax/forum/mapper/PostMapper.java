package com.aymax.forum.mapper;

import com.aymax.forum.dto.PostDto;
import com.aymax.forum.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostDto, Post> {

}
