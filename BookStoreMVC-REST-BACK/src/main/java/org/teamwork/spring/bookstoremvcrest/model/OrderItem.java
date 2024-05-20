package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Specify the order!")
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @NotNull(message = "Specify the order item!")
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @Min(value = 1, message = "Minimal agreed price is 1")
    @Column(name = "item_Agreed_Price")
    private Double itemAgreedPrice;
    @Column(name = "item_comment")
    private String itemComment;
    @Min(value = 1, message = "Minimal count is = 1")
    private Integer amount;

    public OrderItem() {
    }

    public OrderItem(Order order, Book book, Double itemAgreedPrice, String itemComment, Integer amount) {
        this.order = order;
        this.book = book;
        this.itemAgreedPrice = itemAgreedPrice;
        this.itemComment = itemComment;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Double getItemAgreedPrice() {
        return itemAgreedPrice;
    }

    public void setItemAgreedPrice(Double itemAgreedPrice) {
        this.itemAgreedPrice = itemAgreedPrice;
    }

    public String getItemComment() {
        return itemComment;
    }

    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", book=" + book +
                ", itemAgreedPrice=" + itemAgreedPrice +
                ", itemComment='" + itemComment + '\'' +
                ", itemComment=" + amount +
                '}';
    }
}
