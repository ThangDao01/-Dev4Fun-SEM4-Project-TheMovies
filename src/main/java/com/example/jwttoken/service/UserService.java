package com.example.jwttoken.service;

import com.example.jwttoken.entity.UserEntity;
import com.example.jwttoken.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class UserService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("username not fount");
        }

        SimpleGrantedAuthority grand = new SimpleGrantedAuthority(user.getRole().getName());
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = new HashSet<>();
        simpleGrantedAuthorities.add(grand);
        User user1 = new User(user.getUsername(), user.getPassword(), simpleGrantedAuthorities);
         return user1;
    }

    @PreAuthorize("hasAuthority('admin')")
    public String deleteUser(){
        return "success";
    }


}
