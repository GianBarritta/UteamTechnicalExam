package com.solution.demo.service;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;
import com.solution.demo.model.Movie;

import java.util.List;

public interface IMovieService {

    PersonResponseDTO addMovie(PersonRequestDTO dto);

    List<Movie> getAll(Long id);

    void deletePersonMovie(Long id);
}
