package com.aymax.forum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Post implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String post_text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofpublication;
    private String attachement;
    @ManyToOne(optional = false)
    @NotNull
    private User post_owner;
    @JsonManagedReference
    @OneToMany(mappedBy = "belong_post" , cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

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

    public User getPost_owner() {
        return post_owner;
    }

    public void setPost_owner(User post_owner) {
        this.post_owner = post_owner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
