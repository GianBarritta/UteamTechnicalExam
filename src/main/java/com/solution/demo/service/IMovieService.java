package com.solution.demo.service;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;

public interface IMovieService {

    PersonResponseDTO addMovie(PersonRequestDTO dto);

    PersonResponseDTO getAll(Long id);

    void deletePersonMovie(Long id);
}
