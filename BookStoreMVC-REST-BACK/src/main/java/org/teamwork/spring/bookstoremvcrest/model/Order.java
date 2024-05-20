package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Specify customer!")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Costumer costumer;
    @NotNull(message = "Specify order date")
    @Column(name = "order_date")
    private Date orderDate;
    @Min(value = 0, message = "Minimal value is 0")
    @Column(name = "order_value")
    private Double orderValue;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> itemList;

    public Order() {
        itemList = new ArrayList<>();
    }

    public Order(Costumer costumer, Date orderDate, Double orderValue) {
        this.costumer = costumer;
        this.orderDate = orderDate;
        this.orderValue = orderValue;
        itemList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Costumer getCustomer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + costumer +
                ", orderDate=" + orderDate +
                ", orderValue=" + orderValue +
                '}';
    }
}
