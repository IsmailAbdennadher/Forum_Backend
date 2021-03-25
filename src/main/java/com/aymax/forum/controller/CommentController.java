package com.aymax.forum.controller;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.service.interfaces.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment ){
        return this.commentService.createComment(comment);
    }
    @PostMapping("/update")
    public Comment updateComment(@RequestBody Comment comment){
        return this.commentService.updateComment(comment);
    }
    @GetMapping("post/get/{postid}")
    public List<Comment> getCommentsOfPost(@PathVariable long postid){
        return this.commentService.getCommentsOfPost(postid);
    }
    @GetMapping("/{postid}/{userid}")
    public List<Comment> getUserCommentsOfPost(@PathVariable long postid,@PathVariable long userid){
        return this.commentService.getUserCommentsOfPost(postid,userid);
    }
    @GetMapping("get/{commentid}")
    public Comment getCommentById(@PathVariable long commentid){
        return this.commentService.getById(commentid);
    }
}
