package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;







    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User u = userRepository.findByLoginAndPassword(
                user.getLogin(),
                user.getPassword()
        );

        if (u == null) {
            return ResponseEntity.ok(Map.of("status", "INVALID"));
        }

        return ResponseEntity.ok(u);
    }
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//
//        User u = userRepository.findByLoginAndPassword(
//                user.getLogin(),
//                user.getPassword()
//        );
//
//        if (u == null) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(Map.of("status", "INVALID"));
//        }
//
//        return ResponseEntity.ok(u);
//    }
}
