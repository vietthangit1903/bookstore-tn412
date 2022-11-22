package tn412.project.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Address name is required")
    private String name;

    @NotBlank(message = "Address detail is required")
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Address() {
    }

    public Address(Long id, String name, String address, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.user = user;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
