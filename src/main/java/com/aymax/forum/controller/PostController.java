package com.aymax.forum.controller;

import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import com.aymax.forum.service.interfaces.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post ){
        return this.postService.createPost(post);
    }
    @GetMapping("/{postid}")
    public Post getPost(@PathVariable long postid){
        return this.postService.getPost(postid);
    }
    @GetMapping("/{userid}")
    public List<Post> getUserPosts(@PathVariable long userid){
        return this.postService.getUserAllPosts(userid);
    }
}
