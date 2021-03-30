package com.aymax.forum.controller;

import com.aymax.forum.entity.LikePost;
import com.aymax.forum.service.interfaces.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("like/post")
@RestController
public class LikePostController {

    @Autowired
    private LikePostService likeService ;

    @PostMapping("{idUser}/{idPost}")
    public ResponseEntity<LikePost> getUserPosts(@PathVariable("idUser") Long idUser, @PathVariable("idPost") Long idPost){
         return likeService.like(idUser,idPost);
    }
    @GetMapping("isLiked/{idUser}/{idComment}")
    public boolean isLiked(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
        return likeService.isLiked(idUser,idComment);
    }
    @GetMapping("count/{idPost}")
    public int countPostLikes(@PathVariable("idPost") Long idPost){
        return likeService.countPostLikes(idPost);
    }
    @GetMapping("count/all/{idPost}")
    public int countAllPostAndCommentsLikes(@PathVariable("idPost") Long idPost){
        return likeService.countAllPostAndCommentsLikes(idPost);
    }
}
