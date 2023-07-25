package com.ssp2.ssp2.auth;

import com.ssp2.ssp2.config.JwtTokenUtil;
import com.ssp2.ssp2.config.JwtUserDetailsService;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JwtRequest request) {
        try {
            authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),
                    new ArrayList<>()));
            final UserDetails user = jwtUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtTokenUtil.generateToken(user);
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
    }
}
