package tn412.project.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn412.project.dto.BookDto;
import tn412.project.models.Author;
import tn412.project.models.Book;
import tn412.project.models.Category;
import tn412.project.models.Publisher;
import tn412.project.repositories.AuthorRepository;
import tn412.project.repositories.BookRepository;
import tn412.project.repositories.CategoryRepository;
import tn412.project.repositories.PublisherRepository;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	PublisherRepository publisherRepo;

	@GetMapping("/add-book")
	public String showAddBook(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("publishers", publisherRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("book", new BookDto());
		return "/adminBook/add-book";
	}
	
	@PostMapping("/add-book")
	public String saveBook(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult, @RequestParam("image") MultipartFile multipartFile, RedirectAttributes ra) throws IOException, ParseException{
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
		Book newBook = new Book();
		newBook.setName(bookDto.getName());
		newBook.setDescription(bookDto.getDescription());
		newBook.setPrice(bookDto.getPrice());
		newBook.setStock(bookDto.getStock());
		String publishDate = bookDto.getPublishDate();
		Date publishDateParsed = dateParser.parse(publishDate);
		newBook.setPublishDate(publishDateParsed);
		

		Category cate = categoryRepo.findById(bookDto.getCategory()).orElseThrow();
		newBook.setCategory(cate);
		
		Publisher pub = publisherRepo.findById(bookDto.getPublisher()).orElseThrow();
		newBook.setPublisher(pub);
		
		Author author = authorRepo.findById(bookDto.getAuthor()).orElseThrow();
		newBook.setAuthor(author);
		
		newBook.setImage(fileName);

		Book savedBook = bookRepo.save(newBook);
		String uploadDir = "./book-images/" + savedBook.getId(); 
		Path uploadPath = Paths.get(uploadDir);


		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
		Files.copy(inputStream, filePath ,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + fileName);
		}
		
		ra.addFlashAttribute("successMessage", "New book is added successfully");
		return "redirect:/admin/book/add-book";
	}
}