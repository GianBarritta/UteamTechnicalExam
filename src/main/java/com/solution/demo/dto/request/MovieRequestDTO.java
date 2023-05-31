package com.solution.demo.dto.request;

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
public class MovieRequestDTO {

    private String title;

    private String genre;

    private List<Person> persons;
}
