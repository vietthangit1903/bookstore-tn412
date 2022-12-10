package tn412.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tn412.project.repositories.BookRepository;

@Controller
@RequestMapping("")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping("book-list")
    public String getBookList(Model model){
        model.addAttribute("books", bookRepo.findAll());
		return "shop";
    }
    
}
