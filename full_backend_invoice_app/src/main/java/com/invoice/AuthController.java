package com.invoice;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3005")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    // ✅ ADD THIS CONSTRUCTOR
    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername())
                .orElseThrow();

        if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
            return JwtUtil.generateToken(user.getUsername());
        }

        throw new RuntimeException("Invalid Credentials");
    }
}