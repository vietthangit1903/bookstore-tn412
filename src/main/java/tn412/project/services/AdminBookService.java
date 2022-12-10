package tn412.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn412.project.models.Book;
import tn412.project.repositories.BookRepository;

@Service
public class AdminBookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> listAll() {
		return bookRepo.findAll();
	}

	public Book get(Long id) throws UserNotFoundException {
		Optional<Book> result = bookRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Book not found with id " + id);
	}

	public void delete(Long id) throws UserNotFoundException {
		Long count = bookRepo.countById(id);
		if (count == null || count == 0) {
			throw new UserNotFoundException("Book not found with id " + id);
		}
		bookRepo.deleteById(id);
	}
}
