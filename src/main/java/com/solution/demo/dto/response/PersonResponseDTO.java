package com.solution.demo.dto.response;

import com.solution.demo.model.Movie;

import java.util.List;

public class PersonResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthdate;

    private boolean hasInsurance;

    private List<Movie> favouriteMovies;
}
