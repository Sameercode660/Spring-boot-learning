package com.example.demo.controller;

import com.example.demo.Entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("journal")
public class JournalEntry {

    ArrayList<JournalEntity> array = new ArrayList<>();

    @GetMapping
    public List<JournalEntity> fetchJournal () {
        return array;
    }

    @PostMapping
    public boolean insertJournal(@RequestBody JournalEntity entity) {
        array.add(entity);
        return true;
    }

    @DeleteMapping("delete/{id}")
    public JournalEntity deleteJournal(@PathVariable int id) {
        System.out.println(id);
        JournalEntity result = array.remove(id);
        return result;
    }

    @PutMapping("update/{id}")
    public boolean updateJournal(@PathVariable int id, @RequestBody JournalEntity journal) {
        array.set(id, journal);
        return true;
    }

}
