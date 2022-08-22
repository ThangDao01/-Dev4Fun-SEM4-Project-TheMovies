package com.example.jwttoken.controller;


import com.example.jwttoken.dto.MovieDto;
import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movie")
public class ApiMovieController {


    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    private ResponseEntity<?> getProduct(
            @RequestParam(value = "page", required = false, defaultValue = "0")String page,
            @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        return ResponseEntity.ok(movieService.findByAll(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit), Sort.by("name").descending())));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody MovieEntity movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"id"})
    public ResponseEntity<MovieEntity> update(@PathVariable int id, @RequestBody MovieDto movie){
        Optional<MovieEntity> movieEntity = movieService.findById(id);
        if (!movieEntity.isPresent()){
            ResponseEntity.badRequest().build();
        }
        MovieEntity movie1 = movieEntity.get();
        movie1.setName(movie.getName());
        movie1.setDescription(movie.getDescription());
        movie1.setThumbnail(movie.getThumbnail());
        return ResponseEntity.ok(movieService.create(movie1));
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
