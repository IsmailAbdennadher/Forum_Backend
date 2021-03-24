package com.aymax.forum.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "like_post")
public class LikePost implements Serializable {
    @EmbeddedId
    private LikePostPk likePostPk;
    @Temporal(TemporalType.DATE)
    private Date dateoflike;

    public LikePostPk getLikePostPk() {
        return likePostPk;
    }

    public void setLikePostPk(LikePostPk likePostPk) {
        this.likePostPk = likePostPk;
    }

    public Date getDateoflike() {
        return dateoflike;
    }

    public void setDateoflike(Date dateoflike) {
        this.dateoflike = dateoflike;
    }
}
