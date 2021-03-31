package com.aymax.forum.mapper;

import com.aymax.forum.dto.UserDto;
import com.aymax.forum.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDto, User> {
}
