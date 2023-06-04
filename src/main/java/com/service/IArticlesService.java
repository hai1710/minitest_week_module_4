package com.service;

import com.model.Articles;

import java.util.List;

public interface IArticlesService {
    List<Articles> findAll();
    void save(Articles article);
    Articles findById(int id);
    void edit(int id, Articles articles);
    void remote(int id);
}