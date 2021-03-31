package com.aymax.forum.dto;


import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
    private long id;
    private String comment_text;
    private Date dateofpublication;
    private String attachement;
    private UserDto comment_owner;
    private int likes;
    private String dateSinceCommented;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getDateofpublication() {
        return dateofpublication;
    }

    public void setDateofpublication(Date dateofpublication) {
        this.dateofpublication = dateofpublication;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public UserDto getComment_owner() {
        return comment_owner;
    }

    public void setComment_owner(UserDto comment_owner) {
        this.comment_owner = comment_owner;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDateSinceCommented() {
        return dateSinceCommented;
    }

    public void setDateSinceCommented(String dateSinceCommented) {
        this.dateSinceCommented = dateSinceCommented;
    }
}
