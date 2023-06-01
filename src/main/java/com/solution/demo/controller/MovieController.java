package com.solution.demo.controller;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;
import com.solution.demo.model.Movie;
import com.solution.demo.service.IMovieService;
import com.solution.demo.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService service;

    @PostMapping
    public ResponseEntity<PersonResponseDTO> addMovie(@Valid @RequestBody PersonRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMovie(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePersonMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
