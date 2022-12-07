package tn412.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		Author tacgia = new Author();
		model.addAttribute("author", tacgia);
		model.addAttribute("Error", new ResponseObject("", tacgia));
		
		return "/author/create";
	}
	
	@PostMapping("create")
	public String addAuhors(@ModelAttribute("author") Author tacgia, Model model) {
		System.out.println(tacgia.getName());
		Author tgia = authorRepository.findByName(tacgia.getName());
		if(tgia != null) {
			model.addAttribute("author", tgia);
			model.addAttribute("Error", new ResponseObject("Author name error", tgia));
			return "/author/create";
		}
		authorRepository.save(tacgia);
		return "redirect:/author/create";
	}

	@GetMapping("edit/{id}")
	public String editAuthor(Model  model, @PathVariable Long id) {
		Author tacgia = authorRepository.findById(id).orElseThrow();
		if(tacgia != null) {
			model.addAttribute("author", tacgia);
			model.addAttribute("Error", new ResponseObject("", tacgia));
			return "/author/edit";
		}
		return "/author/list";
	}

	@PostMapping("edit/{id}")
	public String editAuthors(Author author, @PathVariable Long id, Model  model) {
		Author tgia = authorRepository.findById(id).orElseThrow();
		tgia.setName(author.getName());
		authorRepository.save(tgia);

		return "redirect:/author/list";
	}

	@GetMapping("delete/{id}")
	public String deleteAuthor(@PathVariable Long id) {
		Author tgia = authorRepository.findById(id).orElseThrow();
		authorRepository.delete(tgia);

		return "redirect:/author/list";
	}

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("listAuthor", authorRepository.findAll());
		return "/author/list";
	}
}