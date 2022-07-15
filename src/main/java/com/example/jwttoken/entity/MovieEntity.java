package com.example.jwttoken.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies", schema = "security", catalog = "")
public class MovieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic
    @Column(name = "view")
    private int view;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "director_id")
    private int directorId;



    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "director_id", insertable = false, updatable = false)
    private DirectorEntity director;

}
