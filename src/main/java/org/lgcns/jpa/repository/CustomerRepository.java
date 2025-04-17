package org.lgcns.jpa.repository;

import org.lgcns.jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // 추가적인 쿼리 메소드가 필요하다면 여기서 정의
    Customer findByName(String name);
    List<Customer> findFirst2ByNameLikeOrderByIdDesc(String name);
}