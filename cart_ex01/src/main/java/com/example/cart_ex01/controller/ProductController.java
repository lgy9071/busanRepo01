package com.example.cart_ex01.controller;

import com.example.cart_ex01.entity.Product;
import com.example.cart_ex01.service.ProductService;
import com.example.cart_ex01.sse.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final SseService sseService;

    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }

    @PostMapping("/restock/{productId}")
    public ResponseEntity<String> restock(@PathVariable Long productId, @RequestParam int quantity) {
        productService.restockProduct(productId, quantity);
        return ResponseEntity.ok("재입고 완료");
    }

    @PostMapping("/reduceStock/{productId}")
    public ResponseEntity<String> reduceStock(@PathVariable Long productId, @RequestParam int quantity) {
        productService.reduceStock(productId, quantity);
        return ResponseEntity.ok("재고 차감 완료");
    }

    // SSE 구독은 SseService에 위임
    @GetMapping("/subscribe/{productId}")
    public SseEmitter subscribe(@PathVariable Long productId) {
        return sseService.subscribe(productId);
    }
}