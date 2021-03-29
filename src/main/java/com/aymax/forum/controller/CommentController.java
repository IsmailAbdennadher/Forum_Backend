package com.aymax.forum.controller;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.User;
import com.aymax.forum.service.interfaces.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable long id) throws Exception {
        try
        {
            this.commentService.deleteComment(id);
            return new ResponseEntity<Comment>(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @GetMapping("get/user/{commentid}")
    public User getUserByComment(@PathVariable long commentid){
        return this.commentService.getUserbyCommentId(commentid);
    }
}
