package com.solution.demo.dto.response;

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
public class MovieResponseDTO implements Serializable{

    private Long id;

    private String title;

    private String genre;

    private List<Movie> favouriteMovies;
}
