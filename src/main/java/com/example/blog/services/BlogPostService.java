package com.example.blog.services;

import com.example.blog.dtos.BlogPostRequest;
import com.example.blog.entities.BlogPost;

import java.util.List;

public interface BlogPostService {
  List<BlogPost> getAllBlogPosts(String term);

  BlogPost getBlogPostById(Long id);

  BlogPost createBlogPost(BlogPostRequest request);

  BlogPost updateBlogPost(Long id, BlogPostRequest request);

  void deleteBlogPost(Long id);
}
