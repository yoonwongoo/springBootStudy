package com.springboot.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Test
@interface CustomUnitTest{

}
   /* 메서드  HTTP    설명
    getForObject  GET     주어진 URL 주소로 HTTP GET 메서드로 객체로 결과를 반환받는다

    getForEntity  GET   주어진 URL 주소로 HTTP GET 메서드로 결과는 ResponseEntity로 반환받는다

    postForLocation

    POST

    POST 요청을 보내고 결과로 헤더에 저장된 URI를 결과로 반환받는다

    postForObject

    POST

    POST 요청을 보내고 객체로 결과를 반환받는다

    postForEntity

    POST

    POST 요청을 보내고 결과로 ResponseEntity로 반환받는다

    delete

    DELETE

    주어진 URL 주소로 HTTP DELETE 메서드를 실행한다

    headForHeaders

    HEADER

    헤더의 모든 정보를 얻을 수 있으면 HTTP HEAD 메서드를 사용한다

    put

    PUT

    주어진 URL 주소로 HTTP PUT 메서드를 실행한다

    patchForObject

    PATCH

    주어진 URL 주소로 HTTP PATCH 메서드를 실행한다

    optionsForAllow

    OPTIONS

    주어진 URL 주소에서 지원하는 HTTP 메서드를 조회한다

    exchange

    any

    HTTP 헤더를 새로 만들 수 있고 어떤 HTTP 메서드도 사용가능하다

    execute

    any

    Request/Response 콜백을 수정할 수 있다*/

public class HelloApiTest {

    @CustomUnitTest
    void helloApiTest(){

      TestRestTemplate rest = new TestRestTemplate();

      ResponseEntity responseEntity =
              rest.getForEntity("http://localhost:8080/hello?name={name}",String.class,"helloSpring");

      assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
      assertThat(responseEntity.getBody()).isEqualTo("Simple Hello ServicehelloSpring");
    }
}
