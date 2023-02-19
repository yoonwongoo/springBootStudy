package com.springboot.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApiTest(){

      TestRestTemplate rest = new TestRestTemplate();

      ResponseEntity responseEntity =
              rest.getForEntity("http://localhost:8080/hello?name={name}",String.class,"helloSpring");

      assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
      assertThat(responseEntity.getBody()).isEqualTo("Simple Hello ServicehelloSpring");
    }
}
