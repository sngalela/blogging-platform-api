package com.example.blog.services.impl;

import com.example.blog.dtos.BlogPostRequest;
import com.example.blog.entities.BlogPost;
import com.example.blog.mappers.BlogPostMapper;
import com.example.blog.repositories.BlogPostRepository;
import com.example.blog.services.BlogPostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogPostServiceImpl implements BlogPostService {

  private final BlogPostRepository blogPostRepository;
  private final BlogPostMapper blogPostMapper;

  @Override
  public List<BlogPost> getAllBlogPosts(String term) {
    if (term != null) {
      return blogPostRepository.search(term);
    }
    return blogPostRepository.findAllWithTags();
  }

  @Override
  public BlogPost getBlogPostById(Long id) {
    return getBlogPost(id);
  }

  @Override
  public BlogPost createBlogPost(BlogPostRequest request) {
    var blogPost = blogPostMapper.toEntity(request);
    return blogPostRepository.save(blogPost);
  }

  @Override
  public BlogPost updateBlogPost(Long id, BlogPostRequest request) {
    var blogPost = getBlogPost(id);
    blogPostMapper.updateEntity(blogPost, request);
    blogPostRepository.save(blogPost);
    return blogPost;
  }

  @Override
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
