package com.dailycodework.dreamshops.services.cart;

import com.dailycodework.dreamshops.models.Cart;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Long initializeNewCart();
}
