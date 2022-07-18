package com.example.jwttoken.repository;

import com.example.jwttoken.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<DirectorEntity, Integer> {

    DirectorEntity findByName(String name);
}
