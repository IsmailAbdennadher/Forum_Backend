package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.*;
import com.aymax.forum.repository.LikePostRepository;
import com.aymax.forum.repository.PostRepository;
import com.aymax.forum.service.interfaces.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private PostRepository postRepository;

    public ResponseEntity<LikePost> like(Long idUser , Long idPost){
        LikePostPk likePostPk = new LikePostPk();

        likePostPk.setUser_id(idUser);
        likePostPk.setPost_id(idPost);
        if(isLiked(idUser,idPost)){

            repository.delete(repository.findByLikePostPk(likePostPk));
            System.out.println("Dislike");
            return new ResponseEntity<>(repository.findByLikePostPk(likePostPk), HttpStatus.valueOf(204));
        }
        else{
            LikePost likePost = new LikePost();
            likePost.setLikePostPk(likePostPk);
            likePost.setDateoflike(new Date());

            repository.save(likePost);
            System.out.println("Like");
            LikePost lp = repository.save(likePost);
            return new ResponseEntity<>(lp, HttpStatus.CREATED);

        }
    }

    public boolean isLiked(Long idUser , Long idPost){
        LikePostPk likePostPk = new LikePostPk();

        likePostPk.setUser_id(idUser);
        likePostPk.setPost_id(idPost);
        if(repository.existsByLikePostPk(likePostPk)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int countPostLikes(long idPost) {
        return this.repository.countPostLikes(idPost);
    }

    @Override
    public int countAllPostAndCommentsLikes(long idPost) {
        Post p =this.postRepository.getOne(idPost);
        if(p.getComments().isEmpty()){
            return this.countPostLikes(idPost);
        }
        return this.repository.countPostAndCommentsLikes(idPost);
    }

}
