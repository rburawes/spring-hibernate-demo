package com.demo.controller;

import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.service.AuthorService;
import com.demo.service.BookService;
import com.demo.util.AppLogger;
import com.demo.util.AuthorPropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BookController extends AppLogger {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    /**
     * Registers the {@link AuthorPropertyEditor} to process {@link Author} input.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Author.class, new AuthorPropertyEditor());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView book() {

        ModelAndView mv = new ModelAndView("register", "book", new Book());

        List<Author> authors = new ArrayList<>();

        try {
            authors = authorService.getAuthors();
        } catch (Exception e) {
            log.error("An error has occurred while retrieving author list. - {}", e.getMessage());
        }

        mv.addObject("authors", authors);
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book, Model model) {

        String title = book.getTitle();
        model.addAttribute("title", book.getTitle());

        try {

            model.addAttribute("authors", book.getAuthors());
            book.setTimeCreated(new Date());
            book.setTimeUpdated(new Date());
            bookService.saveBook(book);
            log.info("Book successfully saved. [{}]", title);

        } catch (Exception e) {
            log.error("An error has occurred while persisting book entity. - {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "failed";
        }

        try {
            List<Book> books = bookService.getBooks();
            model.addAttribute("books", books);
        }catch (Exception e){
            log.error("An error has occurred while retrieving books. - {}", e.getMessage());
        }

        return "success";
    }
}