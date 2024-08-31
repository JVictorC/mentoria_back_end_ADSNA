package com.mentoria.Mentoria_User.controllers;

import com.mentoria.Mentoria_User.domain.dto.PasswordResetDTO;
import com.mentoria.Mentoria_User.domain.dto.PasswordUpdateDTO;
import com.mentoria.Mentoria_User.domain.dto.UpdateProfileDTO;
import com.mentoria.Mentoria_User.domain.dto.UserDTO;
import com.mentoria.Mentoria_User.service.UserService;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findByUserName")
    public ResponseEntity<UserDTO> findByUserRA(@PathParam("userRA") String userRA){
        return ResponseEntity.ok().body(userService.findByUserRA(userRA));
    }

    @PostMapping("/registration")
    public ResponseEntity<UserDTO> inser(@RequestBody UserDTO request){
        return ResponseEntity.ok().body(userService.insert(request));
    }

    @PatchMapping("/updateProfile")
    public ResponseEntity<Void> updateProfile(@PathParam("id") Long id, @RequestBody UpdateProfileDTO request){
        userService.updateProfile(id, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/profileStatus")
    public ResponseEntity<Void> statusProfile(@PathParam("id") Long id){
        userService.statusProfile(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/passwordUpdate")
    public ResponseEntity<Void> passwordUpdate(@PathParam("id") Long id, @RequestBody PasswordUpdateDTO request){
        userService.updatePassword(id, request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/restPassword")
    public ResponseEntity<Void> resetPassword(@RequestBody PasswordResetDTO request){
        userService.resetPassword(request);
        return ResponseEntity.noContent().build();
    }

}
