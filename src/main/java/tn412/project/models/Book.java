package tn412.project.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL (8,2) UNSIGNED")
    private double price;

    @Column(nullable = false, columnDefinition = "INT (8) UNSIGNED")
    private int stock;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date publishDate;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private Set<CartDetail> cartDetails;

    @OneToMany(mappedBy = "book")
    private Set<OrderDetail> orderDetails;

    public Book() {
    }

    public Book(String name, String description, double price, int stock, Date publishDate, String image, Author author, Category category, Publisher publisher) {
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
