package com.example.blog.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
public class BlogPostRequest {
  @NotBlank private String title;

  @NotBlank private String content;

  @NotBlank private String category;

  @NotEmpty private Set<String> tags;
}
