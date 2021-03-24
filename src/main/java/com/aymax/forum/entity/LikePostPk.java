package com.aymax.forum.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikePostPk implements Serializable {
    private long user_id;
    private long post_id;

    public LikePostPk() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikePostPk)) return false;
        LikePostPk that = (LikePostPk) o;
        return user_id == that.user_id && post_id == that.post_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, post_id);
    }
}
