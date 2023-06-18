package com.junseok.springbootdevelop.test;

import org.junit.jupiter.api.*;

public class JUnitTestCycle {
    @BeforeAll // 전체 테스트 시작하기전 1회 실행 static
    static void beforAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전 마다 실행
    public void beforEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll // 전체 테스트를 마치고 종료하기전 1회 실행 static
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach // 테스트를 종료할 떄마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
