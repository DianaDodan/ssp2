package com.ssp2.ssp2.exception;

public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String username) {
        super(String.format("Username %s could not be found.", username));
    }
}
