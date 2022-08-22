package com.example.jwttoken.mapper;

import com.example.jwttoken.dto.MovieDto;
import com.example.jwttoken.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MovieMapper {
    MovieEntity convertToEntity(MovieDto movieDto);
    MovieDto convertDto(MovieEntity movie);
}
