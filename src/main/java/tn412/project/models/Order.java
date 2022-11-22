package tn412.project.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "DECIMAL (9,2) UNSIGNED")
    private double totalPrice;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private String paymentMethod;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(double totalPrice, String paymentStatus, String paymentMethod) {
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
