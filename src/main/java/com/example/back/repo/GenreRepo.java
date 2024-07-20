package com.example.back.repo;

import com.example.back.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends CrudRepository<Genre,Long> {

}
