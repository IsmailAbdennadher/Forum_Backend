package com.aymax.forum.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeCommentPk implements Serializable {
    private long user_id;
    private long comment_id;

    public LikeCommentPk() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikeCommentPk)) return false;
        LikeCommentPk that = (LikeCommentPk) o;
        return user_id == that.user_id && comment_id == that.comment_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, comment_id);
    }
}
