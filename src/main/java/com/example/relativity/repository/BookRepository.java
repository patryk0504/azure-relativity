package com.example.relativity.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.relativity.model.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CosmosRepository<BookEntity, String> {
    Set<BookEntity> findAll();
}
