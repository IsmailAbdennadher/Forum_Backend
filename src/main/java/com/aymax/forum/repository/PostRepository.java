package com.aymax.forum.repository;

import com.aymax.forum.entity.Post;
import com.aymax.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select a from Post a where a.post_owner = ?1")
    List<Post> findByPost_owner(User user);
}
