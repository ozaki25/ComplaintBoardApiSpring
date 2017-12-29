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

import com.example.model.Comment;
import com.example.repository.CommentRepository;

@CrossOrigin
@RestController
@RequestMapping("/categories/{categoryId}/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> index(@PathVariable Long categoryId) {
        return commentRepository.findByCategoryId(categoryId);
    }

    @GetMapping("{id}")
    public Comment show(@PathVariable Long id) {
     return commentRepository.findOne(id);
    }

    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable Long id) {
        commentRepository.delete(id);
    }
}
