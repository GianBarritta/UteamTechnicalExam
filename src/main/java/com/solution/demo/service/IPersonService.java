package com.solution.demo.service;

import com.solution.demo.dto.request.PersonRequestDTO;
import com.solution.demo.dto.response.PersonResponseDTO;

import java.util.List;

public interface IPersonService {

    PersonResponseDTO save(PersonRequestDTO dto);

    PersonResponseDTO getById(Long id);

    PersonResponseDTO getByName(String name, String lastName);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO update(PersonRequestDTO dto);

    void delete(Long id);
}
