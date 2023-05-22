package com.axonactive.personalproject.authenticate;

import com.axonactive.personalproject.entity.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.axonactive.personalproject.entity.Role.ROLE_USER;
import static org.junit.jupiter.api.Assertions.*;

class AuthControllerImplTest {
@Autowired
private AuthControllerImpl authController;

}