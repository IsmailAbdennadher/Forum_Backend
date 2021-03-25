package com.aymax.forum.controller;

import com.aymax.forum.entity.Post;
import com.aymax.forum.service.interfaces.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Post createPost(@RequestBody Post post ) throws Exception {
        return this.postService.createPost(post);
    }
    @PostMapping("/update")
    public Post updatePost(@RequestBody Post post ) throws Exception {
        return this.postService.updatePost(post);
    }
    @GetMapping("get/{postid}")
    public Post getPost(@PathVariable long postid){
        return this.postService.getPost(postid);
    }
    @GetMapping("user/{userid}")
    public List<Post> getUserPosts(@PathVariable long userid){
        return this.postService.getUserAllPosts(userid);
    }
    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long id){
        try
        {
            this.postService.deletePost(id);
            return new ResponseEntity<Post>(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
