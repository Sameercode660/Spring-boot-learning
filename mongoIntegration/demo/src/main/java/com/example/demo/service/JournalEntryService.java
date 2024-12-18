package com.example.demo.service;

import com.example.demo.entity.JournalEntity;
import com.example.demo.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntity journalEntity) {
        journalEntity.setDate(LocalDate.now());
        journalEntryRepository.save(journalEntity);
    }

    public List<JournalEntity> fetchJournal() {
        return journalEntryRepository.findAll();
    }

    public void deleteJournal(String id) {
        journalEntryRepository.deleteById(id);
    }

    public Optional<JournalEntity> findJournalById(String id) {
        return journalEntryRepository.findById(id);
    }
}
