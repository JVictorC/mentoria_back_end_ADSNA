package com.ads4na.Mentoria_Solicitacoes.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloController {


  @Value("${server.port}")
  private String serverPort;

  @GetMapping
  String hello() {
    return "Hello World " + serverPort;
  }

}
