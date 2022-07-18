package com.example.jwttoken.controller;


import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.entity.DirectorEntity;
import com.example.jwttoken.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/director")
public class ApiDirectorController {

    @Autowired
    DirectorService directorService;

    @RequestMapping(method = RequestMethod.GET, path = {"/all"})

    public ResponseEntity<List<DirectorEntity>> getAll(){
        return ResponseEntity.ok(directorService.findByAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/create"})
    public ResponseEntity<?> create(@RequestBody DirectorEntity directorEntity){
        return ResponseEntity.ok(directorService.save(directorEntity));
    }
    @RequestMapping(method = RequestMethod.PUT, path = {"id"})
    public ResponseEntity<DirectorEntity> update(@PathVariable int id, @RequestBody DirectorEntity director){
        Optional<DirectorEntity> optionalDirectorEntity = directorService.findById(id);
        if (!optionalDirectorEntity.isPresent()){
            ResponseEntity.badRequest().build();
        }
        DirectorEntity directorEntity = optionalDirectorEntity.get();
        directorEntity.setId(director.getId());
        directorEntity.setName(director.getName());
        return ResponseEntity.ok(directorService.save(director));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"id"})
    public ResponseEntity<?> delete(@PathVariable int id){
        if (!directorService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        directorService.delete(id);
        System.out.println("success");
        return ResponseEntity.ok().build();
    }
}
