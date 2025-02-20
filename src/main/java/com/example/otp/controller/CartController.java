package com.example.otp.controller;

import com.example.otp.model.Cart;
import com.example.otp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add To Cart API: POST /cart/add?cartId=&productId=&quantity=
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long cartId, 
                                          @RequestParam Long productId, 
                                          @RequestParam int quantity) {
        Cart cart = cartService.addToCart(cartId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    // Remove from Cart API: DELETE /cart/remove?cartId=&productId=
    @DeleteMapping("/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestParam Long cartId, 
                                               @RequestParam Long productId) {
        Cart cart = cartService.removeFromCart(cartId, productId);
        return ResponseEntity.ok(cart);
    }
}
