package com.aymax.forum.entitie;
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


    @OneToMany(mappedBy = "comment_owner")
    private List<Comment> comments ;
    @OneToMany(mappedBy = "post_owner")
    private List<Post> posts ;

    public User(String username , String password){
        this.username = username;
        this.password = password;
    }


}
