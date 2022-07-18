package com.example.jwttoken.service;

import com.example.jwttoken.entity.DirectorEntity;
import com.example.jwttoken.repository.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    DirectorRepo directorRepo;

    public List<DirectorEntity> findByAll(){
        return directorRepo.findAll();
    }

    public DirectorEntity save(DirectorEntity director){
        return directorRepo.save(director);
    }

    public Optional<DirectorEntity> findById(int id){
        return directorRepo.findById(id);
    }


    public DirectorEntity findByName(String name){
        return directorRepo.findByName(name);
    }
    public void delete(int id){
        directorRepo.deleteById(id);
    }
}
