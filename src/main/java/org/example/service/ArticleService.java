package org.example.service;

import org.example.domain.Article;
import org.example.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo articleRepo;

    public Iterable<Article> getAll(){
        return articleRepo.findAll();
    }

    public void addArticle(Article article){
        articleRepo.save(article);
    }

    public List<Article> findByTag(String tag){
        return articleRepo.findByTag(tag);
    }

    public void deleteById(Long id){
        articleRepo.deleteById(id);
    }

    public void deleteArticle(Article article){
        articleRepo.delete(article);
    }

}
