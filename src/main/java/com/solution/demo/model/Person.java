package com.solution.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@SQLDelete(sql = "UPDATE persons SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @NotBlank(message = "Field name cannot be null")
    private String firstName;

    @NotBlank(message = "Field last name cannot be null")
    private String lastName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String birthdate;

    private boolean hasInsurance;

    @OneToMany(mappedBy = "movies")
    private List<Movie> favouriteMovies = new ArrayList<>() {
        public List<Movie> subList(int fromIndex, int toIndex) {
            if (fromIndex >= 0 && toIndex <= size() && fromIndex <= toIndex) {
                if (size() <= 25) {
                    return this;
                } else {
                    int endIndex = Math.min(toIndex, 25);
                    return super.subList(fromIndex, endIndex);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    };

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    private boolean deleted = Boolean.FALSE;

    public void addMovie(Movie movie) {
        this.getFavouriteMovies().add(movie);
    }

    public void removeMovie(Movie movie) {
        this.getFavouriteMovies().remove(movie);
    }
}
