package com.aymax.forum.controller;

import com.aymax.forum.service.implementations.LikeCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class likeCommentController {
    @Autowired
    private LikeCommentServiceImpl likeService ;

    @PostMapping("/{idUser}/{idComment}")
    public boolean getUserPosts(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
        return likeService.like(idUser,idComment);
    }

}
