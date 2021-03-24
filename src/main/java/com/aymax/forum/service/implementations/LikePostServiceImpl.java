package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.LikePost;
import com.aymax.forum.entity.LikePostPk;
import com.aymax.forum.repository.LikePostRepository;
import com.aymax.forum.service.interfaces.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.LongFunction;

@Service
public class LikePostServiceImpl implements LikePostService {

    @Autowired
    private LikePostRepository repository;

    public boolean like(Long idUser , Long idPost){
        LikePostPk likePostPk = new LikePostPk();

        likePostPk.setUser_id(idUser);
        likePostPk.setPost_id(idPost);
        if(repository.existsByLikePostPk(likePostPk)){
            return false;
        }
        else{
            LikePost likePost = new LikePost();
            likePost.setLikePostPk(likePostPk);
            likePost.setDateoflike(new Date());

            repository.save(likePost);
            return true;
        }
    }
}
