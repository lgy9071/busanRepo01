package com.example.cart_ex01.service;

import com.example.cart_ex01.entity.Product;
import com.example.cart_ex01.repository.ProductRepository;
import com.example.cart_ex01.sse.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SseService sseService;

    public void restockProduct(Long productId, int quantity){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품을 찾을 수 없습니다."));
        product.setStock(product.getStock() + quantity);
        if (product.getStock() > 0) {
            product.setSoldOut(false);
        }
        productRepository.save(product);

        // 알림 전송 위임
        sseService.notifyRestock(productId, product.getName());
    }

    public void reduceStock(Long productId, int quantity){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품을 찾을 수 없습니다."));
        int newStock = product.getStock() - quantity;
        product.setStock(newStock < 0 ? 0 : newStock);
        if (product.getStock() == 0) {
            product.setSoldOut(true);
        }
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}