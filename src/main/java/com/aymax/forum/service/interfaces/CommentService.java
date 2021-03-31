package com.aymax.forum.service.interfaces;

import com.aymax.forum.dto.CommentDto;
import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentDto comment);
    Comment updateComment(CommentDto comment);
    Comment getById(long id);
    List<Comment> getCommentsOfPost(long post_id);
    List<Comment> getUserCommentsOfPost(long post_id,long user_id);
    void deleteComment(long id) throws Exception;
    User getUserbyCommentId(long id);
    int countCommentsByUser(long idUser);
}
