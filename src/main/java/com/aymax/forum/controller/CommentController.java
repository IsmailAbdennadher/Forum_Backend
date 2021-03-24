package com.aymax.forum.controller;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.service.interfaces.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment ){
        return this.commentService.createComment(comment);
    }
    @GetMapping("/{postid}")
    public List<Comment> getCommentsOfPost(@PathVariable long postid){
        return this.commentService.getCommentsOfPost(postid);
    }
    @GetMapping("/{postid}/{userid}")
    public List<Comment> getUserCommentsOfPost(@PathVariable long postid,@PathVariable long userid){
        return this.commentService.getUserCommentsOfPost(postid,userid);
    }
}
