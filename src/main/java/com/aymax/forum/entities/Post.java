package com.aymax.forum.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User post_owner;

    private String title ;
    private String post_text;
}
