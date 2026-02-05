package com.example.blog.mappers;

import com.example.blog.dtos.BlogPostRequest;
import com.example.blog.dtos.BlogPostResponse;
import com.example.blog.entities.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BlogPostMapper {
  BlogPost toEntity(BlogPostRequest blogPostRequest);

  BlogPostResponse toDto(BlogPost blogPost);

  void updateEntity(@MappingTarget BlogPost blogPost, BlogPostRequest request);
}
