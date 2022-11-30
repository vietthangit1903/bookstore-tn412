package tn412.project.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import javax.persistence.Column;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "nvarchar(50) not null")
    @NotEmpty(message = "Tên không được rỗng")
    @Length(max = 50, min = 5, message = "Độ dài từ 5 đến 50 ký tự")
//    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
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
}
