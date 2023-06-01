package com.solution.demo.repository;

import com.solution.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    @Query("SELECT firstName FROM Person p WHERE p.firstName = :firstName")
    public String findByFirstName (@Param("firstName") String firstName);

    @Query("SELECT lastName FROM Person p WHERE p.lastName = :lastName")
    public String findByLastName (@Param("lastName") String lastName);
}
