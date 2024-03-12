package com.exam.vibhu.Services;


import com.exam.vibhu.Models.Cartmodel;

import java.util.List;

public interface Cartservices {
    public List<Cartmodel> getAllCarts();
    public Cartmodel getCart(Long id);

    public List<Cartmodel> getCartInDateRange(String startDate , String endDate);
    public List<Cartmodel> getUserCarts(Long userId);
    public Cartmodel addNewCartProduct(Cartmodel cart);
    public List<Cartmodel> updateAProduct(Long productId);
    public List<Cartmodel> deleteCart(Long cartId);

}