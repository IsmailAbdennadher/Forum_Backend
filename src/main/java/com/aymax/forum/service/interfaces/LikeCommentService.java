package com.aymax.forum.service.interfaces;

import com.aymax.forum.entity.LikeComment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface LikeCommentService {

    ResponseEntity<LikeComment> like(Long idUser , Long idPost);
    boolean isLiked(Long idUser , Long idPost);
    int countCommentLikesByComment(long idComment);
}
