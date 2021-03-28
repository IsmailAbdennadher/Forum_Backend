package com.aymax.forum.controller;

import com.aymax.forum.service.implementations.LikeCommentServiceImpl;
import com.aymax.forum.service.interfaces.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like/comment")
public class likeCommentController {
    @Autowired
    private LikeCommentService likeService ;

    @PostMapping("{idUser}/{idComment}")
    public void like(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
         likeService.like(idUser,idComment);
    }
    @GetMapping("isLiked/{idUser}/{idComment}")
    public boolean isLiked(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
        return likeService.isLiked(idUser,idComment);
    }

}
