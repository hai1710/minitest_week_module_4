package com.model;

import java.time.LocalDate;

public class Articles {
    private int id;
    private String title;
    private String content;
    private LocalDate created_date;

    public Articles() {
    }
    public Articles(int id, String title, String content, LocalDate created_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
    }

    public Articles(String title, String content, LocalDate created_date) {
        this.title = title;
        this.content = content;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }
}