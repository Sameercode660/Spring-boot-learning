package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "journal_entries")
public class JournalEntity {

    @Id
    private  String id;
    private String title;
    private String content;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getId() {
        return id;
    }



    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
