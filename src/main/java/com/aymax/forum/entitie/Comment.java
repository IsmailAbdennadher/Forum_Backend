package com.aymax.forum.entitie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    private User comment_owner ;
}
