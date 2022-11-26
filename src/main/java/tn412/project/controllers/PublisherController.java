package tn412.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tn412.project.models.Publisher;
import tn412.project.repositories.PublisherRepository;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("publisher")

public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public String list(ModelMap models, @RequestParam Optional<String> message, @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Publisher> pages = publisherRepository.findAll(pageable);


        if (message.isPresent()){
            models.addAttribute("message", message.get());
        }

        List<Sort.Order> sortOrders = pages.getSort().stream().collect(Collectors.toList());

        if (sortOrders.size()>0){
            Sort.Order order = sortOrders.get(0);
            models.addAttribute("sort", order.getProperty() + "," +  (order.getDirection()== Sort.Direction.ASC?"asc": "desc"));
        }else {
            models.addAttribute("sort", "name");
        }
        models.addAttribute("pages", pages);
        return "publisher/paginate";
    }
//    public String list(ModelMap models, @RequestParam Optional<String> message){
//        Iterable<Publisher> list = publisherRepository.findAll();
//
//        if (message.isPresent()){
//            models.addAttribute("message", message.get());
//        }
//        models.addAttribute("publisher", list);
//        return "publisher/list";
//    }

    @GetMapping("sort")
    public String sort(ModelMap models, @RequestParam Optional<String> message, @SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort){
        Iterable<Publisher> list = publisherRepository.findAll(sort);

        if (message.isPresent()){
            models.addAttribute("message", message.get());
        }
        models.addAttribute("publisher", list);
        return "publisher/sort";
    }

    @GetMapping("paginate")
    public String paginate(ModelMap models, @RequestParam Optional<String> message, @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Publisher> pages = publisherRepository.findAll(pageable);


        if (message.isPresent()){
            models.addAttribute("message", message.get());
        }

        List<Sort.Order> sortOrders = pages.getSort().stream().collect(Collectors.toList());

        if (sortOrders.size()>0){
            Sort.Order order = sortOrders.get(0);
            models.addAttribute("sort", order.getProperty() + "," +  (order.getDirection()== Sort.Direction.ASC?"asc": "desc"));
        }else {
            models.addAttribute("sort", "name");
        }
        models.addAttribute("pages", pages);
        return "publisher/paginate";
    }

    @GetMapping(value = {"newOrEdit", "newOrEdit/{id}"})
    public String newOrEdit (ModelMap models, @PathVariable(name = "id", required = false)Optional<Long> id){
        Publisher publisher;
        if (id.isPresent()){
            Optional<Publisher> existedCate = publisherRepository.findById(id.get());
            publisher = existedCate.isPresent()?existedCate.get(): new Publisher();
        }else {
            publisher = new Publisher();
        }
        models.addAttribute("publisher", publisher);

        return "publisher/newOrEdit";
    }
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(RedirectAttributes attributes, ModelMap models, @Valid Publisher item, BindingResult result){
        if (result.hasErrors()){
            models.addAttribute("publisher", item);
            return "publisher/newOrEdit";
        }

        publisherRepository .save(item);

        attributes.addAttribute("message", "New publisher is saved!");

        return "redirect:/publisher";
    }

    @GetMapping("delete/{id}")
    public String delete(RedirectAttributes attributes, @PathVariable("id") Long id){
        publisherRepository.deleteById(id);
        attributes.addAttribute("message", "The publisher is deleted!");
        return "redirect:/publisher";
    }
}
