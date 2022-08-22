package com.example.jwttoken.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class MovieDto implements Serializable {
    private int id;
    private String name;
    private String description;
    private String thumbnail;
    private int view;
    private int categoryId;
    private DirectorDto directorId;
    private String createdAt;
    private String updatedAt;

}
