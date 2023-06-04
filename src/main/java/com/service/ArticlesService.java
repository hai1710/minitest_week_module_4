package com.service;

import com.model.Articles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticlesService implements IArticlesService {
    private static final Map<Integer, Articles> articles;

    static {
        articles = new HashMap<>();
        articles.put(1, new Articles(1, "Tiêu đề 1 - Giới thiệu", "Nội dung của bài viết giới thiệu", LocalDate.of(2022, 10, 15)));
        articles.put(2, new Articles(2, "Tiêu đề 2 - Mẹo và thủ thuật", "Nội dung của bài viết về mẹo và thủ thuật", LocalDate.of(2022, 11, 20)));
        articles.put(3, new Articles(3, "Tiêu đề 3 - Tìm hiểu sâu", "Nội dung của bài viết tìm hiểu sâu", LocalDate.of(2022, 12, 5)));
        articles.put(4,  new Articles(4, "Tiêu đề 4 - Thực hành tốt nhất", "Nội dung của bài viết về thực hành tốt nhất", LocalDate.of(2023, 1, 10)));
        articles.put(5,  new Articles(5, "Tiêu đề 5 - Kết luận", "Nội dung của bài viết kết luận", LocalDate.of(2023, 2, 25)));
    }
    @Override
    public List<Articles> findAll() {
        return new ArrayList<Articles> (articles.values());
    }

    @Override
    public void save(Articles article) {
        articles.put(article.getId(),article);
    }

    @Override
    public Articles findById(int id) {
        return articles.get(id);
    }

    @Override
    public void edit(int id, Articles article) {
        articles.put(id,article);
    }

    @Override
    public void remote(int id) {
        articles.remove(id);
    }
}
