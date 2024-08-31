package com.mentoria.Mentoria_User.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class HelloController {


  @Value("${server.port}")
  private String serverPort;

  @GetMapping
  String hello() {
    return "Hello World " + serverPort;
  }

}
