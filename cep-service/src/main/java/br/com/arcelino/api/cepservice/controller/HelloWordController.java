package br.com.arcelino.api.cepservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/hello")
public class HelloWordController {

    @GetMapping
    public String hello() {
        return "Hello Word!";
    }

}
