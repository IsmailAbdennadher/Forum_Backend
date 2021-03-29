package com.aymax.forum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comment implements Serializable {


    private long id;
    private String comment_text;
    private Date dateofpublication;
    private String attachement;
    private User comment_owner;

    private Post belong_post;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Temporal(TemporalType.DATE)
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

    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    @NotNull
    public User getComment_owner() {
        return comment_owner;
    }

    public void setComment_owner(User comment_owner) {
        this.comment_owner = comment_owner;
    }

    @ManyToOne(optional = false)
    @JsonBackReference
    public Post getBelong_post() {
        return belong_post;
    }

    public void setBelong_post(Post belong_post) {
        this.belong_post = belong_post;
    }
}
