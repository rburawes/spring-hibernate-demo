package com.demo.controller;

import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.util.AuthorPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Manages the interaction between the user and book processes.
 *
 * @author rburawes
 */
@Controller
@RequestMapping("/bookstore")
public class BookController {

    /**
     * Registers the {@link AuthorPropertyEditor} to process {@link Author} input.
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Author.class, new AuthorPropertyEditor());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView book() {

        ModelAndView mv = new ModelAndView("register", "book", new Book());
        List<Author> authors = new ArrayList<>();

        Author author = new Author();
        author.setId(1);
        author.setGivenName("Martin");
        author.setFamilyName("Odersky");
        author.setTimeCreated(new Date());
        author.setTimeUpdated(new Date());
        authors.add(author);

        Author author2 = new Author();
        author2.setId(2);
        author2.setGivenName("Lex");
        author2.setFamilyName("Spoon");
        author2.setTimeCreated(new Date());
        author2.setTimeUpdated(new Date());
        authors.add(author2);

        mv.addObject("authors", authors);
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book, Model model) {

        model.addAttribute("title", book.getTitle());
        model.addAttribute("authors", book.getAuthors());

        return "success";
    }
}