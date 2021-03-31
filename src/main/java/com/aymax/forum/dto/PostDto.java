package com.aymax.forum.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PostDto implements Serializable {
    private Long id;
    private String title;
    private String post_text;
    private Date dateofpublication;
    private String attachement;
    private UserDto post_owner;
    private List<CommentDto> comments;
    private int likes;
    private String dateSincePosted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
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

    public UserDto getPost_owner() {
        return post_owner;
    }

    public void setPost_owner(UserDto post_owner) {
        this.post_owner = post_owner;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDateSincePosted() {
        return dateSincePosted;
    }

    public void setDateSincePosted(String dateSincePosted) {
        this.dateSincePosted = dateSincePosted;
    }
}
