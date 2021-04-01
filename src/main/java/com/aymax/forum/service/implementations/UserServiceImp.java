package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.User;
import com.aymax.forum.repository.UserRepository;
import com.aymax.forum.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository repository ;

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }
}
