package com.example.jwttoken.seeder;

import com.example.jwttoken.dto.DirectorDto;
import com.example.jwttoken.entity.CategoryEntity;
import com.example.jwttoken.entity.DirectorEntity;
import com.example.jwttoken.entity.MovieEntity;
import com.example.jwttoken.repository.CategoryRepo;
import com.example.jwttoken.repository.DirectorRepo;
import com.example.jwttoken.repository.MovieRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataSeeder implements CommandLineRunner {

    boolean createData =  false;

    final MovieRepo movieRepo;
    final CategoryRepo categoryRepo;
    final DirectorRepo directorRepo;

    Random random = new Random();

    Faker faker = new Faker();

    int numberOfMovie = 100;
    int numberOfCategory = 100;

    int numberOfDirector = 100;


    public DataSeeder(MovieRepo movieRepo, CategoryRepo categoryRepo, DirectorRepo directorRepo) {
        this.movieRepo = movieRepo;
        this.categoryRepo = categoryRepo;
        this.directorRepo = directorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (createData){
            movieRepo.deleteAll();
            seedMovie();
        }
    }

    private void seedMovie(){
        List<MovieEntity> list = new ArrayList<>();
        for (int i = 0; i < numberOfMovie; i++){
            System.out.println(i + 1);
            MovieEntity movie = new MovieEntity();
            movie.setId(Integer.parseInt(UUID.randomUUID().toString()));
            movie.setName(faker.name().title());
            movie.setDescription(faker.lorem().sentence());
            movie.setThumbnail(faker.avatar().image());
            movie.setView(faker.number().randomDigit());
            list.add(movie);
        }
        movieRepo.saveAll(list);
    }
    private void seedCategory(){
        List<CategoryEntity> list = new ArrayList<>();
        for (int j = 0; j < numberOfCategory; j++){
            System.out.println(j + 1);
            CategoryEntity category = new CategoryEntity();
            category.setId(Integer.parseInt(UUID.randomUUID().toString()));
            category.setName(faker.name().title());
            list.add(category);
        }
        categoryRepo.saveAll(list);
    }
    private void seedDirector(){
        List<DirectorEntity> list = new ArrayList<>();
        for (int u = 0; u < numberOfDirector; u++){
            System.out.println(u + 1);
            DirectorEntity director = new DirectorEntity();
            director.setId(Integer.parseInt(UUID.randomUUID().toString()));
            director.setName(faker.name().title());
            director.setAvatar(faker.avatar().image());
            list.add(director);
        }
        directorRepo.saveAll(list);
    }
}
