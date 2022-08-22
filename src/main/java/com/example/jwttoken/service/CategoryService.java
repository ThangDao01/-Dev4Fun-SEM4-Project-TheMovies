package com.example.jwttoken.service;


import com.example.jwttoken.dto.BaseResponse;
import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public BaseResponse<List<CategoryEntity>> findByAll(Pageable pageable){
        return new BaseResponse(HttpStatus.OK, "success", categoryRepo.findAll(pageable).getContent());
    }

    public CategoryEntity save(CategoryEntity category){
        return categoryRepo.save(category);
    }

    public Optional<CategoryEntity> findById(int id){
        return categoryRepo.findById(id);
    }

    public CategoryEntity findByName(String name){
        return categoryRepo.findByName(name);
    }

    public void delete(int id){
        categoryRepo.deleteById(id);
    }
}
