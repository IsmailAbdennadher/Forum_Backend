package com.aymax.forum.controller;

import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.service.implementations.LikeCommentServiceImpl;
import com.aymax.forum.service.interfaces.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("like/comment")
public class likeCommentController {
    @Autowired
    private LikeCommentService likeService ;

    @PostMapping("{idUser}/{idComment}")
    public ResponseEntity<LikeComment> like(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
         return likeService.like(idUser,idComment);
    }
    @GetMapping("isLiked/{idUser}/{idComment}")
    public boolean isLiked(@PathVariable("idUser") Long idUser, @PathVariable("idComment") Long idComment){
        return likeService.isLiked(idUser,idComment);
    }
    @GetMapping("count/{idComment}")
    public int countCommentLikes(@PathVariable("idComment") Long idComment){
        return likeService.countCommentLikesByComment(idComment);
    }
}
