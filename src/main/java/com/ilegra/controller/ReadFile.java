package com.ilegra.controller;

import com.ilegra.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/relatorio")
public class ReadFile {

    @GetMapping
    public void read() throws IOException {
        new RelatorioService().readFile();
    }
}