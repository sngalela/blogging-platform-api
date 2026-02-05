package com.example.blog.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
@JsonPropertyOrder({"id", "title", "content", "category", "tags", "createdAt", "updatedAt"})
public class BlogPostResponse {
  private Long id;

  private String title;

  private String content;

  private String category;

  private Set<String> tags;

  private Instant createdAt;

  private Instant updatedAt;
}
