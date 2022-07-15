package com.example.jwttoken.service;

import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.entity.UserEntity;
import com.example.jwttoken.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public List<MovieEntity> findByAll(){
        return movieRepo.findAll();
    }

    public MovieEntity save(MovieEntity movie){
        return movieRepo.save(movie);
    }

    public MovieEntity FindByName(String name){
        return movieRepo.findByName(name);
    }

}
