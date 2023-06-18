package com.junseok.springbootdevelop.repository;

import com.junseok.springbootdevelop.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
