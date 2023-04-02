package com.springboot.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Objects;

/*controller는 HelloService를 의존하고 있다.
* 근데 나는 지금 다형성을 이용하여 의존성을 주입을 한다.
* 빈만 갈아끼어놓으면 코드의 수정은 하나도 없이 다른기능을 확장을 할 수있다.
* 재사용성에도 좋고 유지보수에도 좋고 결합도도 낮아지고 유연해진다.
* 또 테스트 시 하나의 객체에 여러가지 타입을 받을 수 있으니 좋다*/
@RequestMapping
@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;

    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name){
        if(name==null || name.trim().length()==0) throw  new IllegalArgumentException();

        return helloService.hello(name);
    }


    @GetMapping("/count")
    @ResponseBody
    public String helloCount(String name){

    return "name:"+name+" count:"+helloService.helloCount(name);
    }
}
