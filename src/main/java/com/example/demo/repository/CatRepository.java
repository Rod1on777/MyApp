package com.example.demo.repository;

import com.example.demo.model.Cat;
import com.example.demo.service.CatService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
    void deleteById(Long id);
    Cat getCatById(Long id);
}
