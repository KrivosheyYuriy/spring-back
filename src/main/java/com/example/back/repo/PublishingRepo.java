package com.example.back.repo;

import com.example.back.models.Publishing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepo extends CrudRepository<Publishing, Long> {

}
