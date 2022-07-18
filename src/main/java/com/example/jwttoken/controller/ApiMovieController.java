package com.example.jwttoken.controller;


import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movie")
public class ApiMovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<List<MovieEntity>> getAll(){
        return ResponseEntity.ok(movieService.findByAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity<?> create(@RequestBody MovieEntity movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"id"})
    public ResponseEntity<MovieEntity> update(@PathVariable int id, @RequestBody MovieEntity movie){
        Optional<MovieEntity> movieEntity = movieService.findById(id);
        if (!movieEntity.isPresent()){
            ResponseEntity.badRequest().build();
        }
        MovieEntity movie1 = movieEntity.get();
        movie1.setId(movie.getId());
        movie1.setName(movie.getName());
        movie1.setDescription(movie.getDescription());
        movie1.setThumbnail(movie.getThumbnail());
        return ResponseEntity.ok(movieService.save(movie));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"id"})
    public ResponseEntity<?> delete(@PathVariable int id){
        if (!movieService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        movieService.delete(id);
        System.out.println("success");
        return ResponseEntity.ok().build();
    }
}
