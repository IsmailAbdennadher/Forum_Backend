package com.aymax.forum.controller;

import com.aymax.forum.entity.Post;
import com.aymax.forum.service.implementations.LikePostServiceImpl;
import com.aymax.forum.service.interfaces.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("like/post")
@RestController
public class LikePostController {

    @Autowired
    private LikePostService likeService ;

    @PostMapping("{idUser}/{idPost}")
    public void getUserPosts(@PathVariable("idUser") Long idUser,@PathVariable("idPost") Long idPost){

         likeService.like(idUser,idPost);
    }
    @GetMapping("isLiked/{idUser}/{idComment}")
    public boolean isLiked(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
        return likeService.isLiked(idUser,idComment);
    }


}
