package com.example.productapi.service;

import com.example.productapi.domain.Product;
import com.example.productapi.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository repo;

    // 전체 조회
    public List<Product> findAll() {
        return repo.findAll();
    }

    // 단건 조회
    public Product findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품이 존재하지 않습니다. id=" + id));
    }

    // 생성
    @Transactional
    public Product create(Product product) {
        return repo.save(product);
    }

    // 수정
    @Transactional
    public Product update(Long id, Product updated) {
        Product existing = findById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setStock(updated.getStock());
        return existing;
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        repo.delete(findById(id));
    }
}
