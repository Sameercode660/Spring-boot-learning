package com.example.demo.controller;


import com.example.demo.entity.JournalEntity;
import com.example.demo.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @PostMapping
    public boolean addEntry(@RequestBody JournalEntity entry) {
        journalEntryService.saveEntry(entry);
        return true;
    }

    @GetMapping
    public List<JournalEntity> getAllEntry() {
        return journalEntryService.fetchJournal();
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteEntry(@PathVariable String id) {
        journalEntryService.deleteJournal(id);
        return true;
    }

    @PutMapping("update/{id}")
    public boolean updateEntry(@PathVariable String id, @RequestBody JournalEntity newEntry) {
        JournalEntity old = journalEntryService.findJournalById(id).orElse(null);

        if(old != null) {
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
        } else {
            System.out.println("it is null");
        }

        assert old != null;
        journalEntryService.saveEntry(old);

        return true;
    }
}
