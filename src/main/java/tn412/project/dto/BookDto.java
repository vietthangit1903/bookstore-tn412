package tn412.project.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import tn412.project.models.Author;
import tn412.project.models.Category;
import tn412.project.models.Publisher;

public class BookDto {

	private Long id;

	@NotBlank(message = "Name is requied")
	private String name;

	@NotBlank(message = "Description is requied")
	private String description;

	private double price;

	private int stock;

	private String publishDate;

	private String image;

	private Long author;

	private Long category;

	private Long publisher;

	public BookDto() {
	}

	public BookDto(String name, String description, double price, int stock, String publishDate, String image,
			Long author, Long category, Long publisher) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.publishDate = publishDate;
		this.image = image;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getPublisher() {
		return publisher;
	}

	public void setPublisher(Long publisher) {
		this.publisher = publisher;
	}

	

}
