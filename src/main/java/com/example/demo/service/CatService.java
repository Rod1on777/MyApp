package com.example.demo.service;

import com.example.demo.model.Cat;

import java.awt.*;
import java.util.List;

public interface CatService {
    List<Cat> allCats();
    Cat getCat(Long id);
    Cat createCat(Cat cat);
    Cat updateCat(Cat cat);
    void deleteCat(Long id);

}
