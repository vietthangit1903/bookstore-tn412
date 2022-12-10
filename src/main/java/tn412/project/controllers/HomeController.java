package tn412.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping()
    public String getLogin() {
        return "/index";
    }

    @GetMapping("/account")
    public String getAccount() {
        return "/account";
    }

    @GetMapping("/shop")
    public String getShop(){
        return "/shop";
    }

    @GetMapping("/author")
    public String getAuthor(){
        return "/author";
    }
    @GetMapping("/checkout")
    public String getCheckout(){
        return "/checkout";
    }
    @GetMapping("/book-detail")
    public String getBookDetail(){
        return "/book-detail";
    }
    @GetMapping("/cart")
    public String getCart(){
        return "/cart";
    }
}
