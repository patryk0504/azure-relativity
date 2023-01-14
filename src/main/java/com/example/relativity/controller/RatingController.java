package com.example.relativity.controller;

import com.example.relativity.model.BookEntity;
import com.example.relativity.model.RatingEntity;
import com.example.relativity.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final BookRepository bookRepository;

    @GetMapping("/{id}")
    public String viewRatings(@PathVariable String id, Model model) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("ratings", book.getRatingEntityList());
        return "book-ratings";
    }

    @PostMapping("/{id}")
    public String addRating(@PathVariable String id, @RequestParam int rating) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        BookEntity book = bookRepository.findById(id).orElseThrow();
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setRating(rating);
//        ratingEntity.setBook(book);
        ratingEntity.setUserId(userId);
        book.getRatingEntityList().add(ratingEntity);
        bookRepository.save(book);
        return "redirect:/book/ratings/{id}";
    }
}