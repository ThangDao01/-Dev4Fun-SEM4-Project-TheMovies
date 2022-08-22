package com.example.jwttoken.service;

import com.example.jwttoken.dto.BaseResponse;
import com.example.jwttoken.dto.CategoryDto;
import com.example.jwttoken.dto.MovieDto;
import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.mapper.MovieMapper;
import com.example.jwttoken.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public BaseResponse<List<MovieEntity>> findByAll(Pageable pageable){
        return new BaseResponse(HttpStatus.OK, "success", movieRepo.findAll(pageable).getContent());
    }
    public Optional<MovieEntity> findById(int id){
        return movieRepo.findById(id);
    }
        public MovieEntity save(MovieEntity movie){
        return movieRepo.save(movie);
    }
    public MovieEntity create(MovieEntity movie){
        return movieRepo.save(movie);
    }
    public MovieEntity FindByName(String name){
        return movieRepo.findByName(name);
    }
    public void delete(int id){
        movieRepo.deleteById(id);
    }
}
