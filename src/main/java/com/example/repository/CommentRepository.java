package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>  {

    List<Comment> findByCategoryId(Long categoryId);

}
