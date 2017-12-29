package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> index() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Category show(@PathVariable Long id) {
     return categoryRepository.findOne(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable Long id) {
        categoryRepository.delete(id);
    }
}
