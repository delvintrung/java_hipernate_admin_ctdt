package org.example.project2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ThongTinChungController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @PostMapping("/greet")
    public String greet(@RequestBody Greeting greeting) {
        return "Xin chào, " + greeting.getName();
    }

    static class Greeting {
        private String name;

        // getter + setter
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}

