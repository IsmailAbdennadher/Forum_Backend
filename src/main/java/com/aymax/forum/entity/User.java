package com.aymax.forum.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password ;
    private String name;
    private String email;
    private String dateofbirth;
    private String phone ;

    private String picture ;


    @JsonManagedReference(value = "comment-user")
    @OneToMany(mappedBy = "comment_owner")
    private List<Comment> comments ;
    @JsonManagedReference(value = "post-user")
    @OneToMany(mappedBy = "post_owner")
    private List<Post> posts ;

    public User(Long id){
        this.id = id;
    }
    public User(String username , String password){
        this.username = username;
        this.password = password;
    }


}
