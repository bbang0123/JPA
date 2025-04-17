package org.lgcns.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lgcns.jpa.model.Customer;
import org.lgcns.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@Slf4j
public class JpaPjtApplicationTests {
    // JpaPjtApplicationTests 클래스는 JPA 애플리케이션의 테스트를 위한 클래스입니다.
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void insertTestData() {
        Customer customer = new Customer();
        customer.setName("Test User");
        customerRepository.save(customer);
    }

    @Test
    void findAllTest() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다
        List<Customer> userList = (List<Customer>) customerRepository.findAll();
        for(Customer u : userList) System.out.println("[FindAll]: " + u.getName() );
    }
}
