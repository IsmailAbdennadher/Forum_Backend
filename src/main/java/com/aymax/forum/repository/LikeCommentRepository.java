package com.aymax.forum.repository;

import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import com.aymax.forum.entity.LikePostPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {

    Boolean existsByLikeCommentPk(LikeCommentPk id);

    LikeComment findByLikeCommentPk(LikeCommentPk id);
}
