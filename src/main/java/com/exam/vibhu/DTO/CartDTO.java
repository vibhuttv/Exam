package com.exam.vibhu.DTO;

import com.exam.vibhu.Models.CartProducts;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CartDTO {
    Long id;
    Long userId;
    String date;
    CartProducts[] products;

    public CartDTO(long id, long userId, String date, CartProducts[] products) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public CartProducts[] getProducts() {
//        return products;
//    }

}