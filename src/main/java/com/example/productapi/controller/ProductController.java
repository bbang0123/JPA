package com.example.productapi.controller;

import com.example.productapi.domain.Product;
import com.example.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 관련 API")
public class ProductController {

    private final ProductService service;

    // 1) 전체 조회
    @GetMapping
    @Operation(summary = "전체 상품 조회", description = "모든 상품 정보를 조회합니다.")
    public List<Product> getAll() {
        return service.findAll();
    }

    // 2) 단건 조회
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    // 3) 생성
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = service.create(product);
        return ResponseEntity
                .created(URI.create("/api/products/" + saved.getId()))
                .body(saved);
    }

    // 4) 수정
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    // 5) 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 6) 예외 처리 (간단 버전)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }
}
