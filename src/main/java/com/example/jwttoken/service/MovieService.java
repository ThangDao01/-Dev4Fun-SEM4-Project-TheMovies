package com.example.jwttoken.service;

import com.example.jwttoken.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieService movieService;

    public List<MovieEntity> findByAll(){
        return movieService.findByAll();
    }

    public MovieEntity save(MovieEntity movie){
        return movieService.save(movie);
    }

    public MovieEntity FindByName(String name){
        return movieService.FindByName(name);
    }
}
