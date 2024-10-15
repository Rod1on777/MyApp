package com.example.demo.service.impl;

import com.example.demo.model.Cat;
import com.example.demo.repository.CatRepository;
import com.example.demo.service.CatService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@AllArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public List<Cat> allCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getCat(Long id) {
        return catRepository.getCatById(id);
    }

    @Override
    public Cat createCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    @Transactional
    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
