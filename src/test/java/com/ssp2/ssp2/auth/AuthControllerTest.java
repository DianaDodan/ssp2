package com.ssp2.ssp2.auth;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ssp2.ssp2.config.JwtTokenUtil;
import com.ssp2.ssp2.config.JwtUserDetailsService;
import com.ssp2.ssp2.exception.UsernameNotFoundException;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUserDetailsService jwtUserDetailsService;
    @Mock
    private JwtTokenUtil jwtTokenUtil;
    @InjectMocks
    private AuthController onTest;

    @Test
    public void authenticate_whenValidCredentials_thenReturnToken() {
        //given
        JwtRequest request = new JwtRequest("username", "password");

        //when
        User user = new User(request.getUsername(), request.getPassword(), Collections.emptyList());
        when(authenticationManager.authenticate(any())).thenReturn(mock(Authentication.class));
        when(jwtUserDetailsService.loadUserByUsername(request.getUsername()))
            .thenReturn(user);
        when(jwtTokenUtil.generateToken(user)).thenReturn("token");

        //then
        ResponseEntity<String> test = onTest.authenticate(request);
        assertEquals(HttpStatus.OK, test.getStatusCode());
        assertEquals("token", test.getBody());
    }

    @Test
    public void authenticate_whenInvalidCredentials_thenThrowException() {
        //given
        JwtRequest request = new JwtRequest("username", "password");

        //when
        when(authenticationManager.authenticate(any())).thenThrow(BadCredentialsException.class);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, onTest.authenticate(request).getStatusCode());
    }

    @Test
    public void authenticate_whenUsernameNotFound_thenThrowException() {
        //given
        JwtRequest request = new JwtRequest("username", "password");

        //when
        when(authenticationManager.authenticate(any())).thenReturn(mock(Authentication.class));
        when(jwtUserDetailsService.loadUserByUsername(request.getUsername()))
            .thenThrow(UsernameNotFoundException.class);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, onTest.authenticate(request).getStatusCode());
    }

}