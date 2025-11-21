package com.taskforge.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Post.java
 * Purpose: JPA Entity for posts table
 * - Auto ID + timestamps via @EnableJpaAuditing
 * - Lombok reduces boilerplate to zero
 * - This will become Chemiki v2's main feed post
 */
@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)  // Enables @CreatedDate magic
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;  // Later: User entity + relationship

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // For pretty printing in logs / tests
    @Override
    public String toString() {
        return String.format("Post{id=%d, title='%s', author='%s', createdAt=%s}",
                id, title, author, createdAt);
    }
}