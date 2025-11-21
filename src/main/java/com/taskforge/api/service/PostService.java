package com.taskforge.api.service;

import com.taskforge.api.dto.PostRequestDto;
import com.taskforge.api.dto.PostResponseDto;
import com.taskforge.api.entity.Post;
import com.taskforge.api.exception.ResourceNotFoundException;
import com.taskforge.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PostService.java — FINAL FIXED VERSION
 * Lombok @Builder works like this: Post.builder()...build()
 * NEVER do new Post().builder() — that's why getTitle() etc. were missing
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return toResponseDto(post);
    }

    @Transactional
    public PostResponseDto createPost(PostRequestDto dto) {
        // CORRECT WAY WITH LOMBOK @Builder
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();

        Post saved = postRepository.save(post);
        return toResponseDto(saved);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto dto) {
        Post existing = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        existing.setTitle(dto.getTitle());
        existing.setContent(dto.getContent());
        existing.setAuthor(dto.getAuthor());

        return toResponseDto(postRepository.save(existing));
    }

    @Transactional
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        postRepository.deleteById(id);
    }

    private PostResponseDto toResponseDto(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}