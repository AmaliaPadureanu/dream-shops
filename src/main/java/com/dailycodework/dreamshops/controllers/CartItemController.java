package com.dailycodework.dreamshops.controllers;

import com.dailycodework.dreamshops.exceptions.ResourceNotFoundException;
import com.dailycodework.dreamshops.response.ApiResponse;
import com.dailycodework.dreamshops.services.cart.ICartItemsService;
import com.dailycodework.dreamshops.services.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cartItems")
public class CartItemController {

    private final ICartItemsService cartItemsService;
    private final ICartService cartService;

    @PostMapping("/item/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestParam(required = false) Long cartId,
                                                     @RequestParam Long itemId,
                                                     @RequestParam Integer quantity) {
        if (cartId == null) {
            cartId = cartService.initializeNewCart();
        }

        try {
            cartItemsService.addItemToCart(cartId, itemId, quantity);
            return ResponseEntity.ok(new ApiResponse("Add Item Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status (NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/cart/{cartId}/item/{itemId}/remove")
    public ResponseEntity<ApiResponse> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        try {
            cartItemsService.removeItemFromCart(cartId, itemId);
            return ResponseEntity.ok(new ApiResponse("Remove Item Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/cart/{cartId}/item/{itemId}/update")
    public ResponseEntity<ApiResponse> updateItemQuantity(@PathVariable Long cartId,
                                                          @PathVariable Long itemId,
                                                          @RequestParam Integer quantity) {
        try {
            cartItemsService.updateItemQuantity(cartId, itemId, quantity);
            return ResponseEntity.ok(new ApiResponse("Update Item Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
