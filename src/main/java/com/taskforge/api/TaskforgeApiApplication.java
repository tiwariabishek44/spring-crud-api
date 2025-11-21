package com.taskforge.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * TaskforgeApiApplication.java
 * Purpose: Main entry point for the entire Spring Boot backend
 * - @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 * - @EnableJpaAuditing → auto fills @CreatedDate, @LastModifiedDate in entities
 * This is the heart of Chemiki v2 backend — 100k+ users ready from day 1
 * Project 11/20 — November 21, 2025
 */
@SpringBootApplication
public class TaskforgeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskforgeApiApplication.class, args);

		// Senior-level startup message — Nepal style 👑
		System.out.println("""
            ╔══════════════════════════════════════════════════╗
            ║                                                  ║
            ║    TASKFORGE-API STARTED — NEPAL EDITION         ║
            ║           Spring Boot 3.3 + Java 21              ║
            ║               Project 11/20 Warm-up              ║
            ║                                                  ║
            ╚══════════════════════════════════════════════════╝
            """);
		System.out.println("🔥 Server running on http://localhost:8080");
		System.out.println("📊 H2 Console → http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:taskforgedb)");
		System.out.println("👑 Ready for 100k+ users from day 1 — Chemiki v2 foundation locked!");
	}
}