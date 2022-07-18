package com.example.jwttoken.service;


import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<CategoryEntity> findByAll(){
        return categoryRepo.findAll();
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
