package com.example.supercassa.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sk_example_table")
public class SkExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "jsonb")
    private String obj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
