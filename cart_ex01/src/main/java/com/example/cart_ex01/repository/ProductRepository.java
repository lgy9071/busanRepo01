package com.example.cart_ex01.repository;

import com.example.cart_ex01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
