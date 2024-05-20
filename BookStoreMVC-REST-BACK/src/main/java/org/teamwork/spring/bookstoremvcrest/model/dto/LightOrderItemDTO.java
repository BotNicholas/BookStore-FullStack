package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class LightOrderItemDTO implements DefaultDTO {
    private Integer id;
    @NotEmpty(message = "Specify the order item!")
    private BookDTO book;
    @Min(value = 1, message = "Minipal agreed price is 1")
    private Double itemAgreedPrice;
    private String itemComment;
    @Min(value = 1, message = "Minimal count is = 1")
    private Integer amount;

    public LightOrderItemDTO() {
    }

    public LightOrderItemDTO(BookDTO book, Double itemAgreedPrice, String itemComment, Integer amount) {
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

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
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
        return "OrderItemDTO{" +
                "id=" + id +
                ", book=" + book +
                ", itemAgreedPrice=" + itemAgreedPrice +
                ", itemComment='" + itemComment + '\'' +
                ", itemComment=" + amount +
                '}';
    }
}
