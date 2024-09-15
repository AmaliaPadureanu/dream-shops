package com.dailycodework.dreamshops.services.cart;

import com.dailycodework.dreamshops.models.Cart;
import com.dailycodework.dreamshops.models.User;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
