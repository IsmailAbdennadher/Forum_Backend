package com.aymax.forum.service.interfaces;

import org.springframework.stereotype.Service;


public interface LikeCommentService {

    void like(Long idUser , Long idPost);
    boolean isLiked(Long idUser , Long idPost);
}
