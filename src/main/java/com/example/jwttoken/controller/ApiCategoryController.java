package com.example.jwttoken.controller;


import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, path = {"/all"})
    public ResponseEntity<List<CategoryEntity>> getAll(){
        return ResponseEntity.ok(categoryService.findByAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/create"})
    public ResponseEntity<?> create(@RequestBody CategoryEntity category){
        return ResponseEntity.ok(categoryService.save(category));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"id"})
    public ResponseEntity<CategoryEntity> update(@PathVariable int id, @RequestBody CategoryEntity category){
        Optional<CategoryEntity> optionalCategoryEntity = categoryService.findById(id);
        if (!optionalCategoryEntity.isPresent()){
            ResponseEntity.badRequest().build();
        }
        CategoryEntity categoryEntity = optionalCategoryEntity.get();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        return ResponseEntity.ok(categoryService.save(category));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"id"})
    public ResponseEntity<?> delete(@PathVariable int id){
        if (!categoryService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        categoryService.delete(id);
        System.out.println("success");
        return ResponseEntity.ok().build();
    }
}
