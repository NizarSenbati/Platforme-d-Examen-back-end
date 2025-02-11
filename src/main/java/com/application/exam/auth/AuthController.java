package com.application.exam.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/register/etudiant")
    public ResponseEntity<AuthenticationResponse> registerEtu(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authService.registerEtu(registerRequest));
    }

    @PostMapping("/register/professeur")
    public ResponseEntity<AuthenticationResponse> registerPrf(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authService.registerProf(registerRequest));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }

}
