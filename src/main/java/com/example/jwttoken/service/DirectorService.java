package com.example.jwttoken.service;

import com.example.jwttoken.dto.BaseResponse;
import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.entity.DirectorEntity;
import com.example.jwttoken.repository.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    DirectorRepo directorRepo;

    public BaseResponse<List<DirectorEntity>> findByAll(Pageable pageable){
        return new BaseResponse(HttpStatus.OK, "success", directorRepo.findAll(pageable).getContent());
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
