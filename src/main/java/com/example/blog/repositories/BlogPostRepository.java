package com.example.blog.repositories;

import com.example.blog.entities.BlogPost;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
  @EntityGraph(attributePaths = "tags")
  @Query("SELECT p FROM BlogPost p")
  List<BlogPost> findAllWithTags();

  @EntityGraph(attributePaths = "tags")
  Optional<BlogPost> findBlogPostById(Long id);

  @EntityGraph(attributePaths = "tags")
  @Query(
"""
    SELECT p FROM BlogPost p
    WHERE p.title LIKE %:term%
       OR p.content LIKE %:term%
       OR p.category LIKE %:term%
""")
  List<BlogPost> search(@Param("term") String term);
}
