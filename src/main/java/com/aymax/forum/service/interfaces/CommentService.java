package com.aymax.forum.service.interfaces;

import com.aymax.forum.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment updateComment(Comment comment);
    List<Comment> getCommentsOfPost(long post_id);
    List<Comment> getUserCommentsOfPost(long post_id,long user_id);
    void deleteComment(long id) throws Exception;
}
