package com.junseok.springbootdevelop.service;

import com.junseok.springbootdevelop.domain.Article;
import com.junseok.springbootdevelop.dto.ArticleRequestDto;
import com.junseok.springbootdevelop.dto.ArticleUpdateDto;
import com.junseok.springbootdevelop.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 빈으로 등록
@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 생성
    public Article save(ArticleRequestDto requestDto) {
        return blogRepository.save(requestDto.toEntity());
    }

    // 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 단일 조회
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("not found:" + id));
    }

    // 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 수정
    @Transactional // 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할
    public Article update(long id, ArticleUpdateDto updateDto) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("not found:" + id));

        article.update(updateDto.getTitle(), updateDto.getContent());
        return article;
    }
}
