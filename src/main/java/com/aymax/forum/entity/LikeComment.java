package com.aymax.forum.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "like_comment")
public class LikeComment implements Serializable {

    @EmbeddedId
    private LikeCommentPk likeCommentPk;
    @Temporal(TemporalType.DATE)
    private Date dateoflike;

    public LikeComment() {
    }

    public LikeCommentPk getLikeCommentPk() {
        return likeCommentPk;
    }

    public void setLikeCommentPk(LikeCommentPk likeCommentPk) {
        this.likeCommentPk = likeCommentPk;
    }

    public Date getDateoflike() {
        return dateoflike;
    }

    public void setDateoflike(Date dateoflike) {
        this.dateoflike = dateoflike;
    }

}
