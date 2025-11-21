package com.taskforge.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * PostResponseDto.java
 * Purpose: Outgoing DTO — what client actually receives
 * - Hides internal fields if needed later
 * - Perfect for hiding passwords, relations, etc.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}