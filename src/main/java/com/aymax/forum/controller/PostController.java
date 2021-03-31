package com.aymax.forum.controller;

import com.aymax.forum.dto.PostDto;
import com.aymax.forum.entity.Post;
import com.aymax.forum.mapper.PostMapper;
import com.aymax.forum.repository.LikePostRepository;
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

    @Autowired
    private LikePostRepository likePostRepository;

    public PostController(PostService postService,PostMapper postMapper,LikePostRepository likePostRepository) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.likePostRepository = likePostRepository;
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
        return p;
    }
    @GetMapping("user/{userid}")
    public List<PostDto> getUserPosts(@PathVariable long userid){
        List<PostDto> p = postMapper.toDtoList(this.postService.getUserAllPosts(userid));
        return this.postService.getListDateDiffofPost(p);
    }
    @GetMapping("/all")
    public List<PostDto> getAllPosts(){
        List<PostDto> p = postMapper.toDtoList(this.postService.getAllPosts());
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
