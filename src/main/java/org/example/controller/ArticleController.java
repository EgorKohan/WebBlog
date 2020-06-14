package org.example.controller;

import org.example.domain.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String getArticles(@RequestParam(required = false, defaultValue = "") String filter,
                              Model model) {
        Iterable<Article> articles;
        if (filter != null && !filter.isEmpty()) {
            articles = articleService.findByTag(filter);
        } else {
            articles = articleService.getAll();
        }
        model.addAttribute("articles", articles);
        model.addAttribute("filter", filter);
        return "/articles";
    }

    @PostMapping
    public String addArticle(
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam String tag,
            Model model) {
        Article article = new Article(title, text, tag);
        articleService.addArticle(article);
        model.addAttribute("articles", articleService.getAll());
        return "/articles";
    }

    @GetMapping("/delete/{article}")
    public String deleteArticle(
            @PathVariable Article article,
            Model model) {
        articleService.deleteArticle(article);
        model.addAttribute("articles", articleService.getAll());
        return "/articles";
    }

}
