package com.example.jwttoken.repository;

import com.example.jwttoken.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {

    MovieEntity findByName(String name);
}
