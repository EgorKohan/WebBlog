package org.example.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String text;

    private Status status;

    private Date createdAt;

    private Date updateAt;

    //    @JoinColumn(name = "tag")
    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Article() {
    }

    public Article(String title, String text, String tag, User author) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.setUpdateAt(new Date());
        this.setCreatedAt(new Date());
        this.setStatus(Status.PUBLIC);
        this.author = author;
    }

    public String getAuthorIfExists() {
        return (author == null) ? "<none>" : author.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tagName) {
        this.tag = tagName;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
