package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import com.aymax.forum.repository.PostRepository;
import com.aymax.forum.repository.UserRepository;
import com.aymax.forum.security.service.UserDetailsImpl;
import com.aymax.forum.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post != null && userDetails.getId() != null) {
            long id = userDetails.getId();
            User u = this.userRepository.findById(id).get();
            post.setPost_owner(u);
            return this.postRepository.save(post);
        }
        throw new NullPointerException("le post ou utilisateur fournit est null");
    }

    @Override
    public Post updatePost(Post post) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post != null && userDetails.getId() != null){
            Optional<Post> p = this.postRepository.findById(post.getId());
            Post updatedPost = p.get();
            long id = userDetails.getId();
            User u = this.userRepository.findById(id).get();
            updatedPost.setPost_owner(u);
            updatedPost.setAttachement(post.getAttachement());
            updatedPost.setPost_text(post.getPost_text());
            updatedPost.setTitle(post.getTitle());
            updatedPost.setDateofpublication(post.getDateofpublication());
            return this.postRepository.save(updatedPost);
        }
        throw new NullPointerException("le post ou utilisateur fournit est null");
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

    @Override
    public List<Post> getAllPosts() {
        return this.postRepository.findAll(Sort.by(Sort.Direction.DESC,"dateofpublication"));
    }
}
