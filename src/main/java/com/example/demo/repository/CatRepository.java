package com.example.demo.repository;

import com.example.demo.model.Cat;
import com.example.demo.service.CatService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatRepository extends JpaRepository<Cat, Long> {
    void deleteById(Long id);
    Cat getCatById(Long id);
    boolean existsCatByName(String name);
    Optional<Cat> findCatByName(String name);
}
