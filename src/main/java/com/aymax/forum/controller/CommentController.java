package com.aymax.forum.controller;

import com.aymax.forum.dto.CommentDto;
import com.aymax.forum.dto.PostDto;
import com.aymax.forum.dto.UserDto;
import com.aymax.forum.entity.Comment;
import com.aymax.forum.mapper.CommentMapper;
import com.aymax.forum.mapper.UserMapper;
import com.aymax.forum.repository.LikeCommentRepository;
import com.aymax.forum.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper commentMapper;

    private final UserMapper userMapper;

    @Autowired
    private final LikeCommentRepository likeCommentRepository;

    public CommentController(CommentService commentService ,CommentMapper commentMapper,UserMapper userMapper,
                             LikeCommentRepository likeCommentRepository) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.likeCommentRepository = likeCommentRepository;
    }

    @PostMapping("/create")
    public CommentDto createComment(@RequestBody Comment comment ){
        return commentMapper.toDto(this.commentService.createComment(comment));
    }
    @PostMapping("/update")
    public CommentDto updateComment(@RequestBody CommentDto comment){
        return commentMapper.toDto(this.commentService.updateComment(comment));
    }
    @GetMapping("post/get/{postid}")
    public List<CommentDto> getCommentsOfPost(@PathVariable long postid){
        List<CommentDto> c = commentMapper.toDtoList(this.commentService.getCommentsOfPost(postid));
        return this.commentService.getListDateDiffofComment(c);
    }
    @GetMapping("/{postid}/{userid}")
    public List<CommentDto> getUserCommentsOfPost(@PathVariable long postid,@PathVariable long userid){
        List<CommentDto> c = commentMapper.toDtoList(this.commentService.getUserCommentsOfPost(postid,userid));
        return this.commentService.getListDateDiffofComment(c);
    }
    @GetMapping("get/{commentid}")
    public CommentDto getCommentById(@PathVariable long commentid){
        CommentDto p = commentMapper.toDto(this.commentService.getById(commentid));
        p.setLikes(likeCommentRepository.countCommentLikesByComment(commentid));
        p.setDateSinceCommented(commentService.getDateDiffofComment(commentid));
        return p;
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<CommentDto> deleteComment(@PathVariable long id) throws Exception {
        try
        {
            this.commentService.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @GetMapping("get/user/{commentid}")
    public UserDto getUserByComment(@PathVariable long commentid){
        return userMapper.toDto(this.commentService.getUserbyCommentId(commentid));
    }
    @GetMapping("count/user/{userId}")
    public int getCountCommentsByUser(@PathVariable long userId){
        return this.commentService.countCommentsByUser(userId);
    }
}
