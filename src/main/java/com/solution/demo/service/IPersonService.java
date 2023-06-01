package com.solution.demo.service;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;

import java.util.List;

public interface IPersonService {

    PersonResponseDTO create(PersonRequestDTO dto);

    PersonResponseDTO getById(Long id);

    PersonResponseDTO getByName(Long id, String firstName);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO update(Long id, PersonRequestDTO dto);

    void delete(Long id);
}
