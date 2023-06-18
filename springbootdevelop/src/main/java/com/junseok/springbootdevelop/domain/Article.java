package com.junseok.springbootdevelop.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티로 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 추가
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 1씩 자동 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    // 어느 필드에 어떤 값이 들어가는지 명시적으로 파악이 가능하다.
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // getter -> @Getter(클래스 필드에 대해 별도 코드 없이 생성사 메서드 생성), @NoArgsConstructor(접근제어자가 protected인 기본 생성자를 코드 없이 생기본)로 대체
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
}
