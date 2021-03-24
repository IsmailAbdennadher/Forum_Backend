package com.aymax.forum.controller;

import com.aymax.forum.entity.Post;
import com.aymax.forum.service.implementations.LikePostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("like")
@RestController
public class LikePostController {

    @Autowired
    private LikePostServiceImpl likeService ;

    @PostMapping("/{idUser}/{idPost}")
    public boolean getUserPosts(@PathVariable("idUser") Long idUser,@PathVariable("idPost") Long idPost){

        return likeService.like(idUser,idPost);
    }


}
