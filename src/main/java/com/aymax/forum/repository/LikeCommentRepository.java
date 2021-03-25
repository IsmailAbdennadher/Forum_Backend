package com.aymax.forum.repository;

import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    void deleteByLikeCommentPk(LikeCommentPk lk);
}
