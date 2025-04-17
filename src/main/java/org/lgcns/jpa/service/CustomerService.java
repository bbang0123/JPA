package org.lgcns.jpa.service;

import org.lgcns.jpa.model.Customer;
import org.lgcns.jpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    // CustomerService 클래스는 고객 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
    // 이 클래스는 CustomerRepository를 주입받아 사용합니다.

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 고객 추가
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // 고객 조회
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // 고객 삭제
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
