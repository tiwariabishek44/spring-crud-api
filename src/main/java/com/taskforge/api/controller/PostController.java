package com.taskforge.api.controller;

import com.taskforge.api.dto.PostRequestDto;
import com.taskforge.api.dto.PostResponseDto;
import com.taskforge.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PostController.java
 * Purpose: REST API endpoints for posts
 * - Full CRUD with proper HTTP status codes
 * - @Valid + DTOs = validation before service
 * - ResponseEntity = full control over response
 * - This is exactly how Chemiki v2 feed will work
 */
@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor  // Lombok creates constructor for final fields (PostService)
@CrossOrigin(origins = "*")  // Later: restrict to your Flutter app
public class PostController {

    private final PostService postService;

    // GET /api/v1/posts → Get all posts
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // GET /api/v1/posts/{id} → Get one post
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // POST /api/v1/posts → Create new post
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostRequestDto requestDto) {
        PostResponseDto created = postService.createPost(requestDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);  // 201 Created
    }

    // PUT /api/v1/posts/{id} → Full update
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.updatePost(id, requestDto));
    }

    // PATCH /api/v1/posts/{id} → Partial update (later)
    // DELETE /api/v1/posts/{id} → Delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }
}