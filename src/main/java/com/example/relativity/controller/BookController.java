package com.example.relativity.controller;

import com.example.relativity.model.BookEntity;
import com.example.relativity.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;


    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute BookEntity book) {
        bookRepository.save(book);
        return "redirect:/book";
    }

    @GetMapping
    public String getBooks(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<BookEntity> books = bookRepository.findAll(PageRequest.of(page, 5));
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/{id}/edit")
    public String showEditBookForm(@PathVariable String id, Model model) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/{id}/edit")
    public String editBook(@PathVariable String id, @ModelAttribute BookEntity book) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setDescription(book.getDescription());
        bookRepository.save(bookEntity);
        return "redirect:/book";
    }

    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);
        return "redirect:/book";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id, Model model) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "book-ratings";
    }
}
