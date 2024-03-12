package com.exam.vibhu.Controllers;


import com.exam.vibhu.Models.Cartmodel;
import com.exam.vibhu.Services.FakeStoreApiCartServices;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/carts")
public class CartControllers {

    FakeStoreApiCartServices fakeStoreCartServices = new FakeStoreApiCartServices();


    // Get All Cart Items
    @GetMapping("/all")
    public List<Cartmodel> getAllCart() {
        return fakeStoreCartServices.getAllCarts();
    }

    // Get Cart Items in Date Range
    @GetMapping("/dateRange")
    public List<Cartmodel> getAllCart(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate) {
        System.out.println(startDate + " " + endDate);
        return fakeStoreCartServices.getCartInDateRange(startDate, endDate);
    }

    // Get Cart Item By Id
    @GetMapping("/{id}")
    public Cartmodel getCart(@PathVariable Long id) {

        return fakeStoreCartServices.getCart(id);
    }


    //Get User Cart

    @GetMapping("/user/{userId}")
    public List<Cartmodel> getUserCarts(@PathVariable Long userId) {
        return  fakeStoreCartServices.getUserCarts(userId);
    }

    // Add a new Product in Cart
    @PostMapping(
            value = "/createPerson", consumes = "application/json", produces = "application/json")
    public Cartmodel createPerson(@RequestBody Cartmodel cart) {
        return fakeStoreCartServices.addNewCartProduct(cart);
    }

}

