package com.example.jwttoken.controller;


import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class ApiMovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<List<MovieEntity>> getAll(){
        return ResponseEntity.ok(movieService.findByAll());
    }
}
