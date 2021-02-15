package com.github.richteaman.flyway.multi.migration;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
//import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 *
 */
//@RestController
@SpringBootApplication
public class App 
{
    //@RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
