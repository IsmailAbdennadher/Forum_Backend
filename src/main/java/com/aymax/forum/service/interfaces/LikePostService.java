package com.aymax.forum.service.interfaces;

import com.aymax.forum.entity.LikePost;
import org.springframework.http.ResponseEntity;

public interface LikePostService {

    ResponseEntity<LikePost> like(Long idUser , Long idPost);

    boolean isLiked(Long idUser , Long idPost);

    int countPostLikes(long idPost);

    int countAllPostAndCommentsLikes(long idPost);

}
