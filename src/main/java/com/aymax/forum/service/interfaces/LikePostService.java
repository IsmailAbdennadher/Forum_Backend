package com.aymax.forum.service.interfaces;

public interface LikePostService {

    void like(Long idUser , Long idPost);

    boolean isLiked(Long idUser , Long idPost);

}
