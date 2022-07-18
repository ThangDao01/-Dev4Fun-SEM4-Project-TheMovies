package com.example.jwttoken.repository;

import com.example.jwttoken.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findByName(String name);
}
