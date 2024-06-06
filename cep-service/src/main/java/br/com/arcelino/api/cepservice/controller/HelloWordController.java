package br.com.arcelino.api.cepservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloWordController {

    @GetMapping
    public String helloWord() {
        return "Hello Word!";
    }

}
