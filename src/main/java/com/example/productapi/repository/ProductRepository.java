package com.example.productapi.repository;

import com.example.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 추가 커스텀 메서드 선언 가능 (예: findByName)
}
