package com.aymax.forum.service.interfaces;

import com.aymax.forum.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post) throws Exception;
    Post updatePost(Post post);
    Post getPost(long post_id);
    List<Post> getUserAllPosts(long user_id);
    void deletePost(long id) throws Exception;
    List<Post> getAllPosts();
}
