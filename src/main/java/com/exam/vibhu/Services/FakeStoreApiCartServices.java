package com.exam.vibhu.Services;

import com.exam.vibhu.DTO.CartDTO;
import com.exam.vibhu.Models.Cartmodel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
public class FakeStoreCartServices implements  Cartservices {
    private final String url = "https://fakestoreapi.com/carts";
    RestTemplate restTemplate = new RestTemplate();


    @Override
    public Cartmodel getCart(Long id) {

        CartDTO fakeStoreProductDto =  restTemplate.getForObject(
                url +"/" + id,
                CartDTO.class
        );

        Cartmodel cart = new Cartmodel();
        cart.setId(fakeStoreProductDto.getId());
        cart.setUserId(fakeStoreProductDto.getUserId());
        cart.setDate(fakeStoreProductDto.getDate());
        cart.setCartProducts(fakeStoreProductDto.getProducts());
        return cart;
    }


    @Override
    public List<Cartmodel> getAllCarts() {

        List<CartDTO> cartFetchDTOS = restTemplate.exchange(
                url ,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartDTO>>() {
                }
        ).getBody();

        return cartFetchDTOS.stream().map(this::mapToCart).toList();

    }






    private Cartmodel mapToCart(CartDTO recivedCartDTO) {

        return new Cartmodel(recivedCartDTO.getId(), recivedCartDTO.getUserId(), recivedCartDTO.getDate(), recivedCartDTO.getProducts());
    }


    @Override
    public Cartmodel addNewCartProduct(Cartmodel cart) {

        CartDTO sendCart = mapToCardDTOs(cart);
        sendCart = restTemplate.postForObject(url, sendCart, CartDTO.class);

        System.out.println(Arrays.stream(sendCart.getProducts()).toList());

        return mapToCart(sendCart);

    }

    @Override
    public List<Cartmodel> getCartInDateRange(String startDate, String endDate) {

        List<CartDTO> cartFetchDTOS = restTemplate.exchange(
                url + "?startDate=" + startDate + "&endDate=" + endDate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartDTO>>() {
                }
        ).getBody();

        return cartFetchDTOS.stream().map(this::mapToCart).toList();
    }

    @Override
    public List<Cartmodel> getUserCarts(Long userId) {

        List<CartDTO> cartFetchDTOS = restTemplate.exchange(
                url + "/user/" + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartDTO>>() {
                }
        ).getBody();


        return cartFetchDTOS.stream().map(this::mapToCart).toList();
    }



    private CartDTO mapToCardDTOs(Cartmodel cart) {

        return new CartDTO(cart.getId(), cart.getUserId(), cart.getDate(), cart.getCartProducts());

    }





}