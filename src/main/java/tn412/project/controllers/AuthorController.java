package tn412.project.controllers;

import org.hibernate.validator.cfg.defs.Mod11CheckDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tn412.project.models.Author;
import tn412.project.models.ResponseObject;
import tn412.project.repositories.AuthorRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("create")
	public String addAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		model.addAttribute("Error", new ResponseObject("", author));
		
		return "/author/create";
	}
	
	@PostMapping("create")
	public String addAuhors(Author author, Model model) {
		System.out.println(author.getName());
		Author auth = authorRepository.findByName(author.getName());
		if(auth != null) {
			model.addAttribute("author",auth);
			model.addAttribute("Error", new ResponseObject("Author name error", auth));
			return "/author/create";
		}
		authorRepository.save(author);
		return "redirect:/author/create";
	}
	@GetMapping("edit/{id}")
	public String editAuthor(Model  model, @PathVariable Long id) {
		Author author = authorRepository.findById(id).orElseThrow();
		if(author != null) {
			model.addAttribute("author", author);
			model.addAttribute("Error", new ResponseObject("", author));
			return "/author/edit";
		}
		return "/author/list";
	}
	@PostMapping("edit{id}")
	public String editAuthors(Model  model, @PathVariable Long id, Author author) {
		Author auth = authorRepository.findById(id).orElseThrow();
		auth.setName(auth.getName());
		authorRepository.save(auth);
		return "redirect:/author/list";
	}
	@GetMapping("delete{id}")
	public String deleteAuthor(@PathVariable Long id) {
		Author auth = authorRepository.findById(id).orElseThrow();
		authorRepository.delete(auth);
		return "redirect:/author/list";
	}
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("listAuthor", authorRepository.findAll());
		return "redirect:/author/list";
	}
}
