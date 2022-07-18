package com.example.jwttoken.service;

import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public List<MovieEntity> findByAll(){
        return movieRepo.findAll();
    }

    public Optional<MovieEntity> findById(int id){
        return movieRepo.findById(id);
    }

    public MovieEntity save(MovieEntity movie){
        return movieRepo.save(movie);
    }

    public MovieEntity FindByName(String name){
        return movieRepo.findByName(name);
    }


    public void delete(int id){
        movieRepo.deleteById(id);
    }
}
