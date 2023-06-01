package com.solution.demo.service.impl;

import com.solution.demo.dto.response.MovieResponseDTO;
import com.solution.demo.dto.response.PersonResponseDTO;
import com.solution.demo.exception.*;
import com.solution.demo.mapper.GenericMapper;
import com.solution.demo.model.Movie;
import com.solution.demo.model.Person;
import com.solution.demo.repository.MovieRepository;
import com.solution.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;


    public PersonResponseDTO addPerson(Long movieId, Long personId) {
        Movie movie = getMovieById(movieId);
        Person person = getPersonById(personId);
        person.addMovie(movie);
        personRepository.save(person);
        return mapper.map(person, PersonResponseDTO.class);
    }

    public List<PersonResponseDTO> findAll(){
        Person person = new Person();
        List<Movie> favouriteMovies = person.getFavouriteMovies();
        if (favouriteMovies.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(favouriteMovies, PersonResponseDTO.class);
    }

    public PersonResponseDTO removePerson(Long movieId, Long personId) {
        Movie movie = getMovieById(movieId);
        Person person = getPersonById(personId);
        person.removeMovie(movie);
        personRepository.save(person);
        return mapper.map(person, PersonResponseDTO.class);
    }

    private Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("movie-not-found", new Object[] {id}, Locale.US));
        }
        return movie.get();
    }

    private Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("person-not-found", new Object[] {id}, Locale.US));
        }
        return person.get();
    }
}
