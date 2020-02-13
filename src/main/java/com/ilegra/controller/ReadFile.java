package com.ilegra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class ReadFile {

    @GetMapping
    public String read() {
        return "Desafio Ilegra, buddy";
    }
}