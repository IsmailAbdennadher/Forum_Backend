package com.aymax.forum.service.implementations;


import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import com.aymax.forum.entity.LikePost;
import com.aymax.forum.entity.LikePostPk;
import com.aymax.forum.repository.LikeCommentRepository;
import com.aymax.forum.repository.LikePostRepository;
import com.aymax.forum.service.interfaces.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LikeCommentServiceImpl implements LikeCommentService {
    @Autowired
    private LikeCommentRepository repository;

    public ResponseEntity<LikeComment> like(Long idUser , Long idComment){
        LikeCommentPk likeCommentPk = new LikeCommentPk();

        likeCommentPk.setUser_id(idUser);
        likeCommentPk.setComment_id(idComment);
        if(isLiked(idUser,idComment)){

            repository.delete(repository.findByLikeCommentPk(likeCommentPk));
            System.out.println("Dislike");
            return new ResponseEntity<LikeComment>(repository.findByLikeCommentPk(likeCommentPk), HttpStatus.valueOf(204));
        }
        else{
            LikeComment likeComment = new LikeComment();
            likeComment.setLikeCommentPk(likeCommentPk);
            likeComment.setDateoflike(new Date());

            LikeComment lk = repository.save(likeComment);
            return new ResponseEntity<>(lk, HttpStatus.CREATED);

        }
    }

    public boolean isLiked(Long idUser , Long idComment){
        LikeCommentPk likeCommentPk = new LikeCommentPk();

        likeCommentPk.setUser_id(idUser);
        likeCommentPk.setComment_id(idComment);
        if(repository.existsByLikeCommentPk(likeCommentPk)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int countCommentLikesByComment(long idComment) {
        return this.repository.countCommentLikesByComment(idComment);
    }

}
