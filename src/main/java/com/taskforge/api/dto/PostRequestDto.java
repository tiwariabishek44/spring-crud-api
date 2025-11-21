package com.taskforge.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PostRequestDto.java
 * Purpose: Incoming DTO for creating/updating posts
 * - @Valid will catch these before hitting service
 * - Keeps entity clean from controller junk
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {

    @NotBlank(message = "Title is mandatory king 👑")
    @Size(min = 5, max = 200, message = "Title must be 5-200 chars bro")
    private String title;

    @NotBlank(message = "Content cannot be empty 🔥")
    @Size(min = 10, message = "Content too short — write more like a beast!")
    private String content;

    @NotBlank(message = "Author name required")
    private String author;
}