package com.example.blog.controllers;

import com.example.blog.dtos.BlogPostRequest;
import com.example.blog.dtos.BlogPostResponse;
import com.example.blog.services.BlogPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class BlogPostController {
  private final BlogPostService blogPostService;

  @GetMapping
  public List<BlogPostResponse> getAllBlogPosts(
      @RequestParam(value = "term", required = false) String searchTerm) {
    return blogPostService.getAllBlogPosts(searchTerm);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BlogPostResponse> getBlogPostById(@PathVariable Long id) {
    var blogPost = blogPostService.getBlogPostById(id);
    return ResponseEntity.ok(blogPost);
  }

  @PostMapping
  public ResponseEntity<BlogPostResponse> createBlogPost(
      @RequestBody @Valid BlogPostRequest request, UriComponentsBuilder builder) {
    var blogPost = blogPostService.createBlogPost(request);
    var location = builder.path("/posts/{id}").buildAndExpand(blogPost.getId()).toUri();
    return ResponseEntity.created(location).body(blogPost);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BlogPostResponse> updateBlogPost(
      @PathVariable Long id, @RequestBody @Valid BlogPostRequest request) {
    var blogPost = blogPostService.updateBlogPost(id, request);
    return ResponseEntity.ok(blogPost);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
    blogPostService.deleteBlogPost(id);
    return ResponseEntity.noContent().build();
  }
}
