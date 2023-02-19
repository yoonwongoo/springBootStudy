package com.springboot.learning;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

    public static void run(Class<?> applicationClass, String... args) {
           AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){

               @Override
               protected void onRefresh() {
                   super.onRefresh();

                   ServletWebServerFactory tomcatServletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                   DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                   WebServer webServer = tomcatServletWebServerFactory.getWebServer(sc->sc.addServlet("dispatcherServlet",
                           dispatcherServlet).addMapping("/*"));


                       webServer.start();
               }

           };
           /*빈 구성 정보 위치 정도는 알려줘야지....*/
           applicationContext.register(applicationClass);
           applicationContext.refresh();
       }
}
