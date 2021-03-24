package com.aymax.forum.service.implementations;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import com.aymax.forum.repository.CommentRepository;
import com.aymax.forum.repository.PostRepository;
import com.aymax.forum.repository.UserRepository;
import com.aymax.forum.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment createComment(Comment comment) {
        if(comment != null && comment.getBelong_post() != null && comment.getComment_owner() != null)
            return this.commentRepository.save(comment);
        return null; //TODO create a custom Exception
    }

    @Override
    public Comment updateComment(Comment comment) {
        if(comment != null){
            Optional<Comment> c = this.commentRepository.findById(comment.getId());
            Comment updatedComment = c.get();
            updatedComment.setComment_owner(comment.getComment_owner());
            updatedComment.setAttachement(comment.getAttachement());
            updatedComment.setComment_text(comment.getComment_text());
            updatedComment.setBelong_post(comment.getBelong_post());
            updatedComment.setDateofpublication(comment.getDateofpublication());
            return this.commentRepository.save(updatedComment);
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsOfPost(long post_id) {
        Optional<Post> p = this.postRepository.findById(post_id);
        return this.commentRepository.findByBelong_post(p.get());
    }

    @Override
    public List<Comment> getUserCommentsOfPost(long post_id, long user_id) {
        Optional<Post> p = this.postRepository.findById(post_id);
        Optional<User> u = this.userRepository.findById(user_id);
        return this.commentRepository.findByBelong_postAndComment_owner(p.get(),u.get());
    }

    @Override
    public void deleteComment(long id) throws Exception {
        try {
            this.commentRepository.deleteById(id);
        }
        catch (Exception e){
            throw new Exception("comment with id = " + id + " not found. ");
        }
    }
}
