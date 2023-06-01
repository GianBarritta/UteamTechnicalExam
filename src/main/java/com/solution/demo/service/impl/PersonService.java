package com.solution.demo.service.impl;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;
import com.solution.demo.exception.*;
import com.solution.demo.mapper.GenericMapper;
import com.solution.demo.model.Person;
import com.solution.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository repository;
    private final GenericMapper mapper;
    private final MessageSource messageSource;

    public PersonResponseDTO create(PersonRequestDTO dto) {
        List<Person> persons = repository.findAll();

        persons.forEach(p -> {
            if(repository.findByFirstName(p.getFirstName()).equalsIgnoreCase(dto.getFirstName())
                    && repository.findByLastName(p.getLastName()).equalsIgnoreCase(dto.getLastName())){
                throw new AlreadyExistsException(
                        messageSource.getMessage("person-name-already-exists", null, Locale.US));
            }
        });
        Person entity = mapper.map(dto, Person.class);
        entity.setCreationDate(LocalDateTime.now());
        entity = repository.save(entity);
        return mapper.map(entity, PersonResponseDTO.class);
    }

    public PersonResponseDTO getById(Long id) {
        if (id <= 0) {
            throw new ArithmeticException(messageSource.getMessage("error-negative-id", null, Locale.US));
        }
        Person entity = getPersonById(id);
        return mapper.map(entity, PersonResponseDTO.class);
    }

    public PersonResponseDTO getByName(Long id, String firstName) {
        Person person = getPersonById(id);
        String namePerson = repository.findByFirstName(firstName);
        return mapper.map(namePerson, PersonResponseDTO.class);
    }

    public List<PersonResponseDTO> findAll(){
        List<Person> persons = repository.findAll();
        if (persons.isEmpty()) {
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(persons, PersonResponseDTO.class);
    }

    public PersonResponseDTO update(Long id, PersonRequestDTO dto) {
        Person entity = getPersonById(id);
        try {
            Person updatedEntity = mapper.map(dto, Person.class);
            updatedEntity.setId(entity.getId());
            updatedEntity.setCreationDate(entity.getCreationDate());
            updatedEntity.setUpdateDate(LocalDateTime.now());
            updatedEntity = repository.save(updatedEntity);
            return mapper.map(updatedEntity, PersonResponseDTO.class);
        } catch (Exception e) {
            throw new UnableToUpdateEntityException(messageSource.getMessage("unable-to-update-person",new Object[] {id}, Locale.US));
        }
    }

    public void delete(Long id) {
        Person entity = getPersonById(id);
        try {
            entity.setUpdateDate(LocalDateTime.now());
            repository.deleteById(id);
        } catch (Exception e) {
            throw new UnableToDeleteEntityException(messageSource.getMessage("unable-to-delete-person", new Object[] {id}, Locale.US));
        }
    }

    private Person getPersonById(Long id) {
        Optional<Person> person = repository.findById(id);
        if(person.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("person-not-found", new Object[] {id}, Locale.US));
        }
        return person.get();
    }
}
