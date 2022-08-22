package com.example.jwttoken.repository;

import com.example.jwttoken.entity.MovieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {

    MovieEntity findByName(String name);
}
