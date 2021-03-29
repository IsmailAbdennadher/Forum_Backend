package com.aymax.forum.repository;

import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import com.aymax.forum.entity.LikePostPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    void deleteByLikeCommentPk(LikeCommentPk lk);

    Boolean existsByLikeCommentPk(LikeCommentPk id);

    LikeComment findByLikeCommentPk(LikeCommentPk id);

    @Query(value = "SELECT count(*) FROM Like_Comment a WHERE a.comment_id = ?1",nativeQuery = true)
    int countCommentLikesByComment(long commentid);
}
