package com.example.demo.controller;

import com.example.demo.model.Cat;
import com.example.demo.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MailnController {

    private CatRepository catRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/catsList")
    public String mainCats(Model model) {
        Iterable<Cat> cats = catRepository.findAll();
        model.addAttribute("cats", cats);
        return "mainCats";
    }

    @GetMapping("/catsList/add")
    public String addCats(Model model) {
        return "addCats";
    }

    @PostMapping("/catsList/add")
    public String addCat(@RequestParam String name, @RequestParam LocalDate dob, @RequestParam String description, Model model) {
        Cat cat = new Cat(name, dob, description);
        catRepository.save(cat);
        return "redirect:/catsList";
    }

    @GetMapping("/catsList/{name}")
    public String findCat(@PathVariable String name, Model model) {
        if(!catRepository.existsCatByName(name)){
            return "redirect:/catsList";
        }

        Optional<Cat> cat = catRepository.findCatByName(name);
        ArrayList<Cat> res = new ArrayList<>();
        cat.ifPresent(res::add);
        model.addAttribute("cat", res);
        return "detailsCats";
    }

    @GetMapping("/catsList/{name}/edit")
    public String editCat(@PathVariable String name, Model model){
        if(!catRepository.existsCatByName(name)){
            return("redirect:/catsList");
        }
        Optional<Cat> cat = catRepository.findCatByName(name);
        ArrayList<Cat> res = new ArrayList<>();
        cat.ifPresent(res::add);
        model.addAttribute("cat", res);
        return "editCats";
    }

    @PostMapping("/catsList/{name}/edit")
    public String editCats(@PathVariable String name, @RequestParam LocalDate dob, @RequestParam String description){
        Optional<Cat> res = catRepository.findCatByName(name);
        Cat cat;
        if(res.isPresent()){
            cat = res.get();
        }else{
            System.out.println("Cat is null");
            cat = null;
        }
        cat.setDob(dob);
        cat.setDescription(description);
        catRepository.save(cat);
        return "redirect:/catsList";
    }

    @PostMapping("/catsList/{name}/remove")
    public String removeCat(@PathVariable String name, Model model){
        Optional<Cat> cat = catRepository.findCatByName(name);
        if(cat.isPresent()){
            catRepository.delete(cat.get());
            return "redirect:/catsList";
        }
        System.out.println("Cat not found");
        return "redirect:/error";
    }
}
