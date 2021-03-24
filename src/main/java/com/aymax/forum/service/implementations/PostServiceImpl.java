package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import com.aymax.forum.repository.PostRepository;
import com.aymax.forum.repository.UserRepository;
import com.aymax.forum.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Post post) {

        if(post != null ) {
            User u = this.userRepository.findById(post.getPost_owner().getId()).get();
            post.setPost_owner(u);
            return this.postRepository.save(post);
        }
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        if(post != null){
            Optional<Post> p = this.postRepository.findById(post.getId());
            Post updatedPost = p.get();
            updatedPost.setPost_owner(post.getPost_owner());
            updatedPost.setAttachement(post.getAttachement());
            updatedPost.setPost_text(post.getPost_text());
            updatedPost.setTitle(post.getTitle());
            updatedPost.setDateofpublication(post.getDateofpublication());
            return this.postRepository.save(updatedPost);
        }
        return null;
    }

    @Override
    public Post getPost(long post_id) {
        return this.postRepository.findById(post_id).get();
    }

    @Override
    public List<Post> getUserAllPosts(long user_id) {
        return this.postRepository.findByPost_owner(this.userRepository.findById(user_id).get());
    }

    @Override
    public void deletePost(long id) throws Exception {
        try {
            this.postRepository.deleteById(id);
        }
        catch (Exception e){
            throw new Exception("post with id = " + id + " not found. ");
        }
    }
}
