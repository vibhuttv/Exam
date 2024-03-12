package com.exam.vibhu.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cartmodel {
    private long Id;
    private long userId;
    private String date;
    private CartProducts[] cartProducts;

    public Cartmodel(){
        Id = userId = 0;
        date = "";
        cartProducts = new CartProducts[0];
    }

    public Cartmodel(long id, long userId, String date, CartProducts[] cartProducts) {
        this.Id = id;
        this.userId = userId;
        this.date = date;
        this.cartProducts = cartProducts;
    }



//    public long getId() {
//        return Id;
//    }
//
//    public void setId(long Id) {
//        this.Id = Id;
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
//    public CartProducts[] getCartProducts() {
//        return cartProducts;
//    }
//
//    public void setCartProducts(CartProducts[] cartProducts) {
//        this.cartProducts = cartProducts;
//    }
}


