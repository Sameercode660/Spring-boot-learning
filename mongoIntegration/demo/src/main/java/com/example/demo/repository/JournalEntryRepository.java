package com.example.demo.repository;

import com.example.demo.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntity, String> {
}
