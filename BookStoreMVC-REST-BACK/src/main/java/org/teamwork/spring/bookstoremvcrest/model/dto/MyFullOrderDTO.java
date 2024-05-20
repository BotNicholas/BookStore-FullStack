package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyFullOrderDTO {
    private Integer id;
    private CostumerDTO customer;
    @NotNull(message = "Specify order date")
    private Date orderDate;
    @Min(value = 1, message = "Minimal value is 1")
    private Double orderValue;
    private List<LightOrderItemDTO> itemList;

    public MyFullOrderDTO() {
        itemList = new ArrayList<>();
    }

    public MyFullOrderDTO(CostumerDTO customer, Date orderDate, Double orderValue, List<LightOrderItemDTO> itemList) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderValue = orderValue;
        this.itemList = itemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CostumerDTO getCostumer() {
        return customer;
    }

    public void setCostumer(CostumerDTO customer) {
        this.customer = customer;
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

    public List<LightOrderItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<LightOrderItemDTO> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", orderValue=" + orderValue +
                ", itemList=" + itemList +
                '}';
    }
}
