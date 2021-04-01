package com.aymax.forum.repository;

import com.aymax.forum.entity.LikeComment;
import com.aymax.forum.entity.LikeCommentPk;
import com.aymax.forum.entity.LikePost;
import com.aymax.forum.entity.LikePostPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {
    void deleteByLikePostPk(LikePostPk lk);
    Boolean existsByLikePostPk(LikePostPk id);
    LikePost findByLikePostPk(LikePostPk id);
    @Query(value = "SELECT count(*) FROM Like_Post a WHERE a.post_id = ?1",nativeQuery = true)
    int countPostLikes(long idPost);

    @Query(value = "SELECT count(*) + (select count(*) as test from forum.like_post where like_post.post_id = ?1) FROM forum.like_post as lp right join forum.post as p on lp.post_id=p.id \n" +
            "right join forum.comment as c on p.id = c.belong_post_id \n" +
            "right join forum.like_comment as lc on c.id = lc.comment_id \n" +
            "where p.id = ?1",nativeQuery = true)
    int countPostAndCommentsLikes(long idPost);
}
