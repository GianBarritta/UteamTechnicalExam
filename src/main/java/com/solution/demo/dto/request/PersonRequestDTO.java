package com.solution.demo.dto.request;

import com.solution.demo.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String birthdate;

    private boolean hasInsurance;

    private List<Movie> favouriteMovies;
}
