package com.solution.demo.dto.response;

import com.solution.demo.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {

    private Long id;

    private String title;

    private String genre;

    private List<Person> persons;
}
