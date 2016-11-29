package com.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the details of book, includes author list.
 * Intentionally added comment.
 * @author rburawes
 */
@Entity
@Table(name = "book", schema = "store")
public class Book extends Modifiable {

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Author> authors = new ArrayList<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
