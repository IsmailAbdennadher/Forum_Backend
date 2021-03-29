package com.aymax.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "like_comment")
@Data @NoArgsConstructor @AllArgsConstructor
public class LikeComment implements Serializable {

    @EmbeddedId
    private LikeCommentPk likeCommentPk;
    @Temporal(TemporalType.DATE)
    private Date dateoflike;


    public LikeComment(LikeComment lk) {
        this.likeCommentPk = lk.getLikeCommentPk();
        this.dateoflike = lk.getDateoflike();
    }
}
