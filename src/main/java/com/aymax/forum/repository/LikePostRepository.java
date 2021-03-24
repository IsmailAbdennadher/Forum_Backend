package com.aymax.forum.repository;

import com.aymax.forum.entity.LikePost;
import com.aymax.forum.entity.LikePostPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    Boolean existsByLikePostPk(LikePostPk id);



}
