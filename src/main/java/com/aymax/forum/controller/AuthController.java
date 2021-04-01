package com.aymax.forum.controller;

import javax.validation.Valid;


import com.aymax.forum.entity.User;
import com.aymax.forum.repository.UserRepository;
import com.aymax.forum.security.request.LoginForm;
import com.aymax.forum.security.response.JwtResponse;
import com.aymax.forum.security.jwt.JwtUtils;
import com.aymax.forum.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(userDetails.getId(),
                    jwt,
                    userDetails.getUsername()
            ));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        String passwordCryp = encoder.encode(signUpRequest.getPassword());
        signUpRequest.setPassword(passwordCryp);
        signUpRequest.setPicture("default.jpg");
        userRepository.save(signUpRequest);

        return ResponseEntity.ok().body("User registered successfully!");
    }
    @GetMapping("/user/{userid}")
    public User getUserById(@PathVariable long userid){
        return this.userRepository.findById(userid).get();
    }
    @PostMapping("/user/edit/{userid}")
    public User getUserById(@RequestBody User user,@PathVariable long userid){
        User u = this.userRepository.findById(userid).get();
        u.setEmail(user.getEmail());
        u.setDateofbirth(user.getDateofbirth());
        u.setName(user.getName());
        u.setPhone(user.getPhone());
        return this.userRepository.save(u);
    }
}