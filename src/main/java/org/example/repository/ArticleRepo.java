package org.example.repository;

import org.example.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    List<Article> findByTag(String tag);

    void deleteById(Long id);

}
