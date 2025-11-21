package com.taskforge.api.repository;

import com.taskforge.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PostRepository.java
 * Purpose: Spring Data JPA magic — zero boilerplate CRUD
 * - Extends JpaRepository → get findAll, save, delete, etc. for FREE
 * - Ready for custom queries later (e.g. findByAuthor, findByTitleContaining)
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//     Future queries:
     List<Post> findByAuthor(String author);
     List<Post> findByTitleContainingIgnoreCase(String keyword);
}