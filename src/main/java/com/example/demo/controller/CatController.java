package com.example.demo.controller;


import com.example.demo.model.Cat;
import com.example.demo.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public List<Cat> allCats(){
        return catService.allCats();
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable Long id){
        return catService.getCat(id);
    }

    @PostMapping("/create")
    public Cat createCat(@RequestBody Cat cat){
        return catService.createCat(cat);
    }

    @PutMapping("/update")
    public Cat updateCat(@RequestBody Cat cat){
        return catService.updateCat(cat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
    }
}
