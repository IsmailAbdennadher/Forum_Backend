package com.aymax.forum.repository;

import com.aymax.forum.entity.Comment;
import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select a from Comment a where a.belong_post = ?1")
    List<Comment> findByBelong_post(Post post);
    @Query(value = "select a from Comment a where a.belong_post = ?1 and a.comment_owner = ?2")
    List<Comment> findByBelong_postAndComment_owner(Post post, User user);
    @Query(value = "SELECT count(*) FROM Comment a WHERE a.belong_post_id = ?1",nativeQuery = true)
    int countCommentsByBelong_post(long postId);
    @Query(value = "SELECT count(*) FROM Comment a WHERE a.comment_owner_id = ?1",nativeQuery = true)
    int countCommentsByUser(long userId);
}
