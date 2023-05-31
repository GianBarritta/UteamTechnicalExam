package com.solution.demo.dto.response;

import com.solution.demo.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthdate;

    private boolean hasInsurance;

    private List<Movie> favouriteMovies;
}