package com.aymax.forum.service.implementations;


import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import com.aymax.forum.entity.LikePost;
import com.aymax.forum.entity.LikePostPk;
import com.aymax.forum.repository.LikeCommentRepository;
import com.aymax.forum.repository.LikePostRepository;
import com.aymax.forum.service.interfaces.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LikeCommentServiceImpl implements LikeCommentService {
    @Autowired
    private LikeCommentRepository repository;

    public void like(Long idUser , Long idComment){
        LikeCommentPk likeCommentPk = new LikeCommentPk();

        likeCommentPk.setUser_id(idUser);
        likeCommentPk.setComment_id(idComment);
        if(isLiked(idUser,idComment)){

            repository.delete(repository.findByLikeCommentPk(likeCommentPk));
            System.out.println("Dislike");
        }
        else{
            LikeComment likeComment = new LikeComment();
            likeComment.setLikeCommentPk(likeCommentPk);
            likeComment.setDateoflike(new Date());

            repository.save(likeComment);
            System.out.println("Like");

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

}
