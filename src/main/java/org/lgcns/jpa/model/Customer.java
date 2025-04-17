package org.lgcns.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }
    // 기본 생성자, Getter, Setter, toString()
}