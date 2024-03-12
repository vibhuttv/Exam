package com.exam.vibhu.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProducts {
    int Id, quantity;

    public CartProducts()
    {
        this.Id = this.quantity = 0;
    }

    public CartProducts(int Id, int quantity) {
        this.Id = Id;
        this.quantity = quantity;
    }
}
