package com.aymax.forum.service.interfaces;

import com.aymax.forum.dto.PostDto;
import com.aymax.forum.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    Post createPost(Post post) throws Exception;
    Post updatePost(PostDto post);
    Post getPost(long post_id);
    List<Post> getUserAllPosts(long user_id);
    void deletePost(long id) throws Exception;
    List<Post> getAllPosts();
    int getNBCommentsOfPost(long post_id);
    List<PostDto> getListDateDiffofPost(List<PostDto> id);
    String getDateDiffofPost(Long idpost);
}
