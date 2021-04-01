package com.aymax.forum.controller;

import com.aymax.forum.dto.CommentDto;
import com.aymax.forum.dto.PostDto;
import com.aymax.forum.entity.Post;
import com.aymax.forum.mapper.PostMapper;
import com.aymax.forum.repository.LikeCommentRepository;
import com.aymax.forum.repository.LikePostRepository;
import com.aymax.forum.service.interfaces.CommentService;
import com.aymax.forum.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    private final CommentService commentService;

    @Autowired
    private final LikePostRepository likePostRepository;

    @Autowired
    private final LikeCommentRepository likeCommentRepository;

    public PostController(PostService postService,PostMapper postMapper,LikePostRepository likePostRepository,
    CommentService commentService,LikeCommentRepository likeCommentRepository) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.likePostRepository = likePostRepository;
        this.commentService = commentService;
        this.likeCommentRepository = likeCommentRepository;
    }

    @PostMapping("/create")
    public PostDto createPost(@RequestBody Post post ) throws Exception {
        return postMapper.toDto(this.postService.createPost(post));
    }
    @PostMapping("/update")
    public PostDto updatePost(@RequestBody PostDto post ) throws Exception {
        return postMapper.toDto(this.postService.updatePost(post));
    }
    @GetMapping("get/{postid}")
    public PostDto getPost(@PathVariable long postid){
        PostDto p = postMapper.toDto(this.postService.getPost(postid));
        p.setLikes(likePostRepository.countPostLikes(postid));
        p.setDateSincePosted(postService.getDateDiffofPost(postid));
        for(CommentDto c : p.getComments()){
            c.setDateSinceCommented(this.commentService.getDateDiffofComment(c.getId()));
            c.setLikes(this.likeCommentRepository.countCommentLikesByComment(c.getId()));
        }
        return p;
    }
    @GetMapping("user/{userid}")
    public List<PostDto> getUserPosts(@PathVariable long userid){
        List<PostDto> p = postMapper.toDtoList(this.postService.getUserAllPosts(userid));
        for(PostDto ps : p){
            for(CommentDto c : ps.getComments()){
                c.setDateSinceCommented(this.commentService.getDateDiffofComment(c.getId()));
                c.setLikes(this.likeCommentRepository.countCommentLikesByComment(c.getId()));
            }
        }
        return this.postService.getListDateDiffofPost(p);
    }
    @GetMapping("/all")
    public List<PostDto> getAllPosts(){
        List<PostDto> p = postMapper.toDtoList(this.postService.getAllPosts());
        for(PostDto ps : p){
            for(CommentDto c : ps.getComments()){
                c.setDateSinceCommented(this.commentService.getDateDiffofComment(c.getId()));
                c.setLikes(this.likeCommentRepository.countCommentLikesByComment(c.getId()));
            }
        }
        return this.postService.getListDateDiffofPost(p);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable long id){
        try
        {
            this.postService.deletePost(id);
            return new ResponseEntity<PostDto>(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @GetMapping("get/number/{postid}")
    public int getNBCommentsOfPost(@PathVariable long postid){
        return this.postService.getNBCommentsOfPost(postid);
    }
}
