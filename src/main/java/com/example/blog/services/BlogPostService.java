package com.example.blog.services;

import com.example.blog.dtos.BlogPostRequest;
import com.example.blog.dtos.BlogPostResponse;
import com.example.blog.entities.BlogPost;
import com.example.blog.mappers.BlogPostMapper;
import com.example.blog.repositories.BlogPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogPostService {

  private final BlogPostRepository blogPostRepository;
  private final BlogPostMapper blogPostMapper;

  public List<BlogPostResponse> getAllBlogPosts(String term) {
    if (term != null) {
      return blogPostRepository.search(term)
              .stream()
              .map(blogPostMapper::toDto)
              .toList();
    }
    return blogPostRepository.findAllWithTags()
            .stream()
            .map(blogPostMapper::toDto)
            .toList();
  }

  public BlogPostResponse getBlogPostById(Long id) {
    return blogPostMapper.toDto(getBlogPost(id));
  }

  public BlogPostResponse createBlogPost(BlogPostRequest request) {
    var blogPost = blogPostMapper.toEntity(request);
    return blogPostMapper.toDto(blogPostRepository.save(blogPost));
  }

  public BlogPostResponse updateBlogPost(Long id, BlogPostRequest request) {
    var blogPost = getBlogPost(id);
    blogPostMapper.updateEntity(blogPost, request);
    return blogPostMapper.toDto(blogPostRepository.save(blogPost));
  }

  public void deleteBlogPost(Long id) {
    var blogPost = getBlogPost(id);
    blogPostRepository.delete(blogPost);
  }

  private BlogPost getBlogPost(Long id) {
    var blogPost = blogPostRepository.findBlogPostById(id).orElse(null);
    if (blogPost == null) {
      throw new NoSuchElementException("Blog post not found");
    }
    return blogPost;
  }
}
